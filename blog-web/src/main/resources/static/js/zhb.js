/**
 * Created by haibozhang on 2018/12/30.
 */
var musicList = [
    {src: 'music/1.mp3', imageurl: 'img/background3.jpg', name: '夫妻那些事主题曲', singer: '何洁、陈楚生'},
    {src: 'music/2.mp3', imageurl: 'img/background2.jpg', name: '如果我们不曾相遇', singer: '五月天'},
    {src: 'music/3.mp3', imageurl: 'img/background1.jpg', name: '带着梦想去旅行', singer: '庄心妍'},
]
var index = 0;
function endFunc(){
    var count = (index + 1) % 3;
    myAudio.checkAudio(musicList[index].src, musicList[index].imageurl,
        musicList[index].name, musicList[index].singer);
    index = count;
}
function nextFunc(){
    var count = (index + 1) % 3;
    myAudio.checkAudio(musicList[index].src, musicList[index].imageurl,
        musicList[index].name, musicList[index].singer);
    index = count;
}
var myAudio = new Daudio({
        ele: '.d-audio', 									// 音乐append的元素
        imageurl: musicList[index].imageurl, 				// 音乐封面
        src: musicList[index].src, 							// 音乐地址
        name: musicList[index].name, 						// 音乐名字
        singer: musicList[index].singer, 					// 音乐歌手
        showprogress: true, 								// 是否显示进度信息
        initstate: 'circle', 								// '' 就是默认状态， cricle则是初始化就是圆形且可以旋转
        loop: false, 										// 是否循环
        ended: endFunc,
        next: nextFunc                                      // 音乐下一曲的点击事件触发，需要配合checkAudio体现切歌的效果
});
myAudio.play();