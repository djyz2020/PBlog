<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>图片文字识别</title>
    <style>
        .container {
            width: 400px;
            margin: 0 auto;
            text-align: center;
        }
        #video {
            width: 400px;
            height: 250px;
            border: 1px solid grey;
            border-radius: 4px;
        }
        #canvas {
            width: 400px;
            height: 240px;
            border: 1px solid grey;
            border-radius: 4px;
        }
    </style>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div style="font-size: 18px;font-weight: 600;margin-top: 10px; color: #2a6496">图片文字识别系统</div>
    <div style="margin-top: 10px;">
        <video id="video" autoplay style="border: 1px solid grey; border-radius: 3px;"></video>
    </div>
    <div style="margin-bottom: 4px;">
        <button class="btn btn-primary"  id="open" style="width: 120px;">打开摄像头</button>
        <button class="btn btn-primary"  id="take" style="width: 120px;">拍照</button>
    </div>
    <div>
        <canvas id="canvas" style="border: 1px solid grey; border-radius: 3px;" width="640" height="480"></canvas>
    </div>
    <div style="width: 98%;margin-left: 1%;">识别结果：</div>
    <textarea id="result" class="el-icon-plus" style="width: 400px;min-height: 120px;"></textarea>
</div>
</body>
<script>
    var Open = document.getElementById("open");
    var oVideo = document.getElementById("video");
    var oTake = document.getElementById("take");
    var oCanvas = document.getElementById('canvas');
    var context = oCanvas.getContext('2d');
    var exArray = []; //存储设备源ID

    navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia
            || navigator.mozGetUserMedia || navigator.msGetUserMedia;
    window.URL = window.URL || window.webkitURL || window.mozURL || window.msURL;

    // 开启按钮
    Open.onclick = function () {
        if (navigator.getUserMedia) {
            navigator.getUserMedia({
                'video': {
                    'optional': [{
                        'sourceId': exArray[1]
                    }]
                },
            }, successFunc, errorFunc);
        } else {
            alert('不支持摄像头');
        }
    };

    // 拍照按钮
    oTake.onclick = function () {
        context.drawImage(oVideo, 0, 0, 640, 480);
        var req = new XMLHttpRequest();
        var base64 = oCanvas.toDataURL();
        console.log(base64);
        var _base64 = base64.substring(base64.indexOf("base64") + 7, base64.length);
        var data = "action=postPicture&base64=" + _base64;
        // 提交到OCRController进行处理
        req.open("POST", "/image2Text", true);
        req.onreadystatechange = function () {
            if ((req.readyState == 4) && (req.status == 200)) {
                var json = req.responseText.length > 0 ? JSON.parse(req.responseText) : {};
                if (json.code != 200){
                    alert("提交失败");
                }else{
                    $("#result").val(json.data);
                }
            }
        };
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        req.send(data);
    };

    // 开启失败
    function errorFunc(e) {
        alert('Error！' + e);
    }

    // 开启成功
    function successFunc(stream) {
        if (oVideo.mozSrcObject !== undefined) {
            oVideo.mozSrcObject = stream;
        }
        else {
            oVideo.src = window.URL && window.URL.createObjectURL(stream) || stream;
        }
    }

</script>
</html>