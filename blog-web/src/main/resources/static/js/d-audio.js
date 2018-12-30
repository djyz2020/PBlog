var Daudio = function(e) {
	var t = {};

	function i(o) {
		if(t[o]) return t[o].exports;
		var n = t[o] = {
			i: o,
			l: !1,
			exports: {}
		};
		return e[o].call(n.exports, n, n.exports, i), n.l = !0, n.exports
	}
	return i.m = e, i.c = t, i.d = function(e, t, o) {
		i.o(e, t) || Object.defineProperty(e, t, {
			configurable: !1,
			enumerable: !0,
			get: o
		})
	}, i.r = function(e) {
		Object.defineProperty(e, "__esModule", {
			value: !0
		})
	}, i.n = function(e) {
		var t = e && e.__esModule ? function() {
			return e.default
		} : function() {
			return e
		};
		return i.d(t, "a", t), t
	}, i.o = function(e, t) {
		return Object.prototype.hasOwnProperty.call(e, t)
	}, i.p = "", i(i.s = 1)
}({
	0: function(e, t, i) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		t.dom = {
			hasClass: function(e, t) {
				return new RegExp("(^|\\s)" + t + "(\\s|$)").test(e.className)
			},
			addClass: function(e, t) {
				if(!this.hasClass(e, t)) {
					var i = e.className.split(" ");
					i.push(t), e.className = i.join(" ")
				}
			},
			removeClass: function(e, t) {
				if(this.hasClass(e, t)) {
					var i = e.className.split(" ");
					i.forEach(function(e, o, n) {
						e === t && i.splice(o, 1)
					}), e.className = i
				}
			},
			getData: function(e, t, i) {
				i ? e.setAttribute(t, i) : e.getAttribute(t)
			},
			addCss: function(e) {
				var t = document.createElement("link");
				t.setAttribute("rel", "stylesheet"), t.setAttribute("type", "text/css"), t.setAttribute("href", e), document.head.appendChild(t)
			},
			addJs: function(e) {
				var t = document.createElement("script");
				t.type = "text/script", t.src = e, document.getElementsByTagName("html")[0].appendChild(t)
			},
			getScrollWidth: function() {
				var e, t, i = document.createElement("div");
				return i.style.cssText = "position:absolute; top:-1000px; width:100px; height:100px; overflow:hidden;", e = document.body.appendChild(i).clientWidth, i.style.overflowY = "scroll", t = i.clientWidth, document.body.removeChild(i), e - t
			}
		}
	},
	1: function(e, t, i) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var o = function() {
			function e(e, t) {
				for(var i = 0; i < t.length; i++) {
					var o = t[i];
					o.enumerable = o.enumerable || !1, o.configurable = !0, "value" in o && (o.writable = !0), Object.defineProperty(e, o.key, o)
				}
			}
			return function(t, i, o) {
				return i && e(t.prototype, i), o && e(t, o), t
			}
		}();
		i(12);
		var n = i(0);
		var a = function() {
			function e(t) {
				! function(e, t) {
					if(!(e instanceof t)) throw new TypeError("Cannot call a class as a function")
				}(this, e);
				document.getElementById("d-audio-content") ? console.error("you have already init d-auido, do not init again") : (this.opt = Object.assign({
					ele: "#d-audio",
					imageurl: "http://www.daiwei.org/sunmmer.jpg",
					src: "",
					name: "",
					singer: "",
					showprogress: !0,
					initstate: "",
					loop: !1,
					ended: function() {},
					next: function() {}
				}, t), "string" == typeof this.opt.ele && (this.opt.ele = document.querySelector(this.opt.ele)), this.loading = !1, this.isplaying = !1, this.progress = 0, this.height = this.opt.ele.offsetHeight || 50, this.duration = 0, this.currentTime = 0, this.defaultimg = "http://www.daiwei.org/sunmmer.jpg", this.dom = {
					cricleImage: null,
					playPause: null,
					next: null,
					audioTitle: null,
					audioSinger: null
				}, this.initAudio(), this.initEvent())
			}
			return o(e, [{
				key: "initAudio",
				value: function() {
					var e = this.dom;
					e.audioContent = document.createElement("div"), "cricle" === this.opt.initstate ? (e.audioContent.className = "audio-content " + this.opt.initstate, e.audioContent.style.width = this.height + "px") : e.audioContent.className = "audio-content", e.audioContent.setAttribute("id", "d-audio-content"), this.opt.ele.appendChild(e.audioContent), e.audioCricle = document.createElement("div"), e.audioCricle.className = "audio-cricle", e.audioCricle.title = this.opt.name + " - " + this.opt.singer, e.audioCricle.innerHTML = '<img id="d-audio-cricleImage" src=' + (this.opt.imageurl || this.defaultimg) + ">", e.audioCricle.style.cssText = "width: " + this.height + "px; height: " + this.height + "px;", e.audioContent.appendChild(e.audioCricle), e.audioDetail = document.createElement("div"), e.audioDetail.className = "audio-detail", e.audioDetail.innerHTML = '<div class="left-config">\n                                      <i id="d-audio-playPause" class="pause icon-pause"></i>\n                                      <i id="d-audio-next" class="next icon-next"></i>\n                                    </div>\n                                    <div class="right-info">\n                                      <h3 id="d-audio-audioTitle" class="m-title">' + this.opt.name + '</h3>\n                                      <p id="d-audio-audioSinger" class="m-singer">' + this.opt.singer + "</p>\n                                    </div>", e.audioContent.appendChild(e.audioDetail), e.audioBg = document.createElement("div"), e.audioBg.className = "audio-bg", e.audioBg.style.cssText = 'background: url("' + (this.opt.imageurl || this.defaultimg) + '");background-size: cover;background-position: center;', e.audioContent.appendChild(e.audioBg), e.audioLoading = document.createElement("div"), e.audioLoading.className = "audio-loading", e.audioLoading.innerHTML = '<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"  width="200px" height="200px"  viewBox="0 0 200 200"\n                                    xml:space="preserve">\n                                    \x3c!--#4886CD为深色值   #9DBFE4为中间值 可以随意修改--\x3e  \n                                    <style type="text/css">\n                                    .left{fill:url(#left);}\n                                    .right{fill:url(#right);}\n                                    .top{fill:rgba(72, 134, 205, 0.781);}\n                                    @keyframes load{\n                                    0%{transform:rotate(0)}\n                                    100%{transform:rotate(-360deg)}\n                                    }\n                                    #load{animation:load 1s  linear infinite; transform-origin:center center; } \n                                    </style>\n                                    <g id="load">\n                                    <linearGradient id="right" gradientUnits="userSpaceOnUse" x1="150" y1="20" x2="150" y2="180">\n                                    <stop  offset="0" style="stop-color:rgba(72, 134, 205, 0.849)"/>\n                                    <stop  offset="1" style="stop-color:rgba(157, 191, 228, 0.788)"/>\x3c!--蓝到浅蓝渐变--\x3e\n                                    </linearGradient>\n                                    <path class="right" d="M100,0v20c44.1,0,80,35.9,80,80c0,44.1-35.9,80-80,80v20c55.2,0,100-44.8,100-100S155.2,0,100,0z"/>\x3c!--右半圆环--\x3e\n                                    <linearGradient id="left" gradientUnits="userSpaceOnUse" x1="50" y1="0" x2="50" y2="180">\n                                    <stop  offset="0" style="stop-color:rgba(255, 255, 255, 0.808)"/>\n                                    <stop  offset="1" style="stop-color:rgba(157, 191, 228, 0.767)"/>\x3c!--浅蓝到白色渐变--\x3e\n                                    </linearGradient>\n                                    <path class="left" d="M20,100c0-44.1,35.9-80,80-80V0C44.8,0,0,44.8,0,100s44.8,100,100,100v-20C55.9,180,20,144.1,20,100z"/>\x3c!--左半圆环--\x3e\n                                    <circle class="top" cx="100" cy="10" r="10"/>\n                                    </g>\n                                  </svg>', e.audioContent.appendChild(e.audioLoading), this.opt.showprogress && (e.audioProgress = document.createElement("div"), e.audioProgress.className = "audio-progress", e.audioContent.appendChild(e.audioProgress)), e.audioEle = document.createElement("audio"), e.audioEle.src = this.opt.src, this.opt.loop && (e.audioEle.loop = !0), e.audioContent.appendChild(e.audioEle), this.initDomInfo()
				}
			}, {
				key: "initDomInfo",
				value: function() {
					this.dom.cricleImage = document.getElementById("d-audio-cricleImage"), this.dom.playPause = document.getElementById("d-audio-playPause"), this.dom.next = document.getElementById("d-audio-next"), this.dom.audioTitle = document.getElementById("d-audio-audioTitle"), this.dom.audioSinger = document.getElementById("d-audio-audioSinger")
				}
			}, {
				key: "initEvent",
				value: function() {
					var e = this,
						t = this.dom,
						i = this;
					t.audioCricle.onclick = function() {
						n.dom.removeClass(t.audioContent, "cricle")
					}, t.audioDetail.onclick = function() {
						n.dom.addClass(t.audioContent, "cricle"), t.audioContent.style.width = e.height + "px"
					}, t.playPause.onclick = function(e) {
						e.stopPropagation(), i.playPause()
					}, t.next.onclick = function(e) {
						e.stopPropagation(), i.opt.next()
					}, t.audioEle.onplaying = function(o) {
						i.isplaying = !0, n.dom.addClass(t.audioCricle, "active"), n.dom.removeClass(t.playPause, "icon-pause"), n.dom.addClass(t.playPause, "icon-play"), e.hideLoading()
					}, t.audioEle.onpause = function(e) {
						i.isplaying = !1, n.dom.removeClass(t.audioCricle, "active"), n.dom.removeClass(t.playPause, "icon-play"), n.dom.addClass(t.playPause, "icon-pause")
					}, t.audioEle.onended = function() {
						n.dom.removeClass(t.playPause, "icon-pause"), n.dom.addClass(t.playPause, "icon-play"), i.opt.next()
					}, t.audioEle.oncanplay = function() {
						i.loading = !1, i.duration = t.audioEle.duration
					}, this.opt.showprogress && (t.audioEle.ontimeupdate = function(e) {
						i.updateProgress(e.target.currentTime)
					}), t.audioEle.onwaiting = function() {
						i.showLoading()
					}, t.audioEle.onerror = function(e) {
						console.error(e), i.opt.next()
					}
				}
			}, {
				key: "checkAudio",
				value: function(e) {
					var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : this.defaultimg,
						i = arguments[2],
						o = arguments[3],
						n = this.dom;
					n.audioEle.src = e, n.cricleImage.src = t, n.audioBg.style.cssText = 'background: url("' + t + '");background-size: cover;background-position: center;', n.audioTitle.innerText = i, n.audioSinger.innerText = o, n.audioCricle.title = i + " - " + o, this.play()
				}
			}, {
				key: "playPause",
				value: function() {
					this.dom.audioEle.paused ? this.play() : this.pause()
				}
			}, {
				key: "play",
				value: function() {
					this.dom.audioEle.play()
				}
			}, {
				key: "pause",
				value: function() {
					this.dom.audioEle.pause()
				}
			}, {
				key: "updateProgress",
				value: function(e) {
					var t = this.dom;
					this.currentTime = e, this.progress = this.currentTime / this.duration, t.audioProgress.style.width = 100 * this.progress + "%"
				}
			}, {
				key: "showLoading",
				value: function() {
					this.loading = !0, n.dom.addClass(this.dom.audioLoading, "active")
				}
			}, {
				key: "hideLoading",
				value: function() {
					this.loading = !1, n.dom.removeClass(this.dom.audioLoading, "active")
				}
			}]), e
		}();
		t.default = a
	},
	12: function(e, t) {}
}).default;