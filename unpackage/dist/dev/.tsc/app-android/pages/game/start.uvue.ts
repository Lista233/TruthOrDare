import {watch,ref} from 'vue'
	
const __sfc__ = defineComponent({
  __name: 'start',
  setup(__props): any | null {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	let firstStart=ref(true);
	let keylist=uni.getStorageInfoSync().keys;
	let curshow=ref(keylist[0])
	let list=uni.getStorageSync(curshow.value) as Array<string>		
	let wordList=ref(list)
	let showView=ref('Press Start')
	let flag=false
	let timerid:number=0;
	let index=0;
	let textChange=ref(false);
	let isClicked=ref(false)
	let radlist=getApp().globalData.randomlist;
	function playaudio(url:string)
	{  
		let audio=uni.createInnerAudioContext();
		audio.src=(url)
		console.log(1, " at pages/game/start.uvue:31")
		//audio.autoplay=true;
		audio.play()
		audio.onEnded(()=>
		{
			audio.destroy()
		})
	}
	onHide(()=>{
		console.log('hide', " at pages/game/start.uvue:40");
		flag=false;
		clearInterval(timerid);
	})
	onUnload(()=>
	{
		console.log('unload', " at pages/game/start.uvue:46");
		flag=false;
		clearInterval(timerid);
	})
	
	function roll()
	{
		if(firstStart.value)
		{
			firstStart.value=!firstStart.value
		}
		console.log(1, " at pages/game/start.uvue:57")
		flag=!flag
		isClicked.value=flag
		if(flag)
		{
			playaudio('/static/voice/开始.wav')
			timerid=setInterval(
			()=>{
				console.log(index, " at pages/game/start.uvue:65")
				index=(index+1)%wordList.value.length
				showView.value=wordList.value[index]
				//console.log(showView.value)
			}
			,100)
		}
		else
		{
			
		 if(radlist.length>=wordList.value.length)
		 {radlist.length=0}
			clearInterval(timerid);
			let rad=Math.floor( Math.random()*wordList.value.length)
			 while(radlist.includes(rad)){rad=(rad+1)%wordList.value.length}
			 console.log(radlist, " at pages/game/start.uvue:80")
			 console.log('rad:'+rad, " at pages/game/start.uvue:81")
			showView.value=wordList.value[rad]
			textChange.value=true;
			console.log('index:'+rad+'value:'+wordList.value[rad], " at pages/game/start.uvue:84")
			radlist.push(rad)
			playaudio('/static/voice/抽取结束.wav')
			setTimeout(()=>{
			textChange.value=false;
			},100)
		
		}
	}
function showList()
{
	
	let op:ShowActionSheetOptions={
	  //title:'词条选项',
	  itemList:keylist,
	  success:(res)=>{
		  curshow.value=keylist[res.tapIndex!]
		  wordList.value=uni.getStorageSync(curshow.value) as Array<string>
	  }
	
	}
	uni.showActionSheet(op);
}


return (): any | null => {

const _component_navigator = resolveComponent("navigator")

  return createElementVNode("view", utsMapOf({ class: "demo2" }), [
    createVNode(_component_navigator, utsMapOf({
      "open-type": "navigateBack",
      "animation-type": "pop-out",
      url: "/pages/index/index",
      class: "Exit"
    }), utsMapOf({
      default: withSlotCtx((): any[] => [
        createElementVNode("text", utsMapOf({
          selectable: "false",
          class: "ExitText"
        }), "< 返回")
      ]),
      _: 1 /* STABLE */
    })),
    createElementVNode("view", utsMapOf({
      class: "sel",
      onClick: () => {showList()}
    }), [
      createElementVNode("text", utsMapOf({ class: "selText" }), "当前列表:" + toDisplayString(unref(curshow)), 1 /* TEXT */)
    ], 8 /* PROPS */, ["onClick"]),
    createElementVNode("view", utsMapOf({
      class: "showtext",
      onClick: () => {roll()}
    }), [
      createElementVNode("view", utsMapOf({ class: "textbox" }), [
        createElementVNode("text", utsMapOf({
          class: normalizeClass(["textcontent", utsMapOf({'textcontentchange':unref(textChange)})]),
          selectable: "false"
        }), toDisplayString(unref(showView)), 3 /* TEXT, CLASS */)
      ])
    ], 8 /* PROPS */, ["onClick"])
  ])
}
}

})
export default __sfc__
const GenPagesGameStartStyles = [utsMapOf([["demo2", padStyleMapOf(utsMapOf([["height", "100%"], ["width", "100%"], ["backgroundImage", "linear-gradient(to bottom, #000000, #1A1A1A)"], ["backgroundColor", "rgba(0,0,0,0)"], ["display", "flex"], ["alignItems", "center"], ["justifyContent", "center"], ["zIndex", -1]]))], ["Exit", utsMapOf([[".demo2 ", utsMapOf([["zIndex", 200], ["position", "fixed"], ["marginLeft", "6%"], ["marginTop", "4%"], ["width", 100], ["height", 50]])]])], ["ExitText", utsMapOf([[".demo2 .Exit ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "center"]])]])], ["sel", utsMapOf([[".demo2 ", utsMapOf([["zIndex", 1], ["position", "fixed"], ["right", "29%"], ["marginTop", "3%"], ["width", 300], ["height", 50]])]])], ["selText", utsMapOf([[".demo2 .sel ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "center"]])]])], ["showtext", utsMapOf([[".demo2 ", utsMapOf([["transitionDuration", "500ms"], ["transitionProperty", "transform"], ["height", 200], ["width", 600], ["borderWidth", 5], ["borderStyle", "solid"], ["borderColor", "#1A1A1A"], ["borderTopLeftRadius", 20], ["borderTopRightRadius", 50], ["borderBottomRightRadius", 20], ["borderBottomLeftRadius", 50], ["boxShadow", "4px 3px 4px #e91e63"], ["position", "relative"]])]])], ["textbox", utsMapOf([[".demo2 .showtext ", utsMapOf([["position", "absolute"], ["width", "100%"], ["height", "100%"], ["display", "flex"], ["justifyContent", "center"], ["alignContent", "center"]])]])], ["textcontent", utsMapOf([[".demo2 .showtext .textbox ", utsMapOf([["position", "absolute"], ["boxSizing", "border-box"], ["width", "100%"], ["maxHeight", 500], ["color", "#FFFFFF"], ["lineHeight", "50px"], ["fontFamily", "像素字"], ["fontSize", 45], ["textAlign", "center"], ["transitionProperty", "transform,opacity"], ["transitionDuration", "700ms"], ["opacity", 1], ["transitionDelay", "0ms"], ["transitionTimingFunction", "ease-out"]])]])], ["textcontentchange", utsMapOf([[".demo2 .showtext .textbox ", utsMapOf([["position", "absolute"], ["boxSizing", "border-box"], ["width", "100%"], ["maxHeight", 500], ["lineHeight", "45px"], ["fontFamily", "像素字"], ["textAlign", "center"], ["opacity", 0.5], ["transitionProperty", "transform"], ["transitionDuration", "50ms"], ["transitionDelay", "0ms"], ["transitionTimingFunction", "ease-out"], ["transform", "scale(1.6, 1.6)"]])]])], ["showtextHover", utsMapOf([[".demo2 .showtext ", utsMapOf([["transitionDuration", "500ms"], ["height", "100%"], ["width", "100%"], ["borderWidth", 5], ["borderStyle", "solid"], ["borderColor", "#1A1A1A"], ["borderTopLeftRadius", 20], ["borderTopRightRadius", 50], ["borderBottomRightRadius", 20], ["borderBottomLeftRadius", 50], ["boxShadow", "4px 3px 4px #e91e63"], ["position", "relative"], ["backgroundColor", "#e91e63"], ["transform", "scale(0.8, 0.8)"]])]])], ["@FONT-FACE", utsMapOf([["0", utsMapOf([["fontFamily", "像素字"], ["src", "url(\"../static/锐字太空奇遇像素.ttf\")"]])]])], ["@TRANSITION", utsMapOf([["showtext", utsMapOf([["duration", "500ms"], ["property", "transform"]])], ["textcontent", utsMapOf([["property", "transform,opacity"], ["duration", "700ms"], ["delay", "0ms"], ["timingFunction", "ease-out"]])], ["textcontentchange", utsMapOf([["property", "transform"], ["duration", "50ms"], ["delay", "0ms"], ["timingFunction", "ease-out"]])], ["showtextHover", utsMapOf([["duration", "500ms"]])]])]])]
