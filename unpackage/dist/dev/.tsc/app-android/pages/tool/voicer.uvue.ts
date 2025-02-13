const __sfc__ = defineComponent({
  __name: 'voicer',
  setup(__props): any | null {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	let audiolist:Array<InnerAudioContext>=[];
	let timeidlist:Array<number>=[];
	function playAudioReapeat(url:string)
	{
		let audio=uni.createInnerAudioContext();
		audio.src=(url)
		audiolist.push(audio);
		console.log(1, " at pages/tool/voicer.uvue:33")
		//audio.autoplay=true;
		audio.play()
		audio.loop=true;
		audio.onEnded(()=>
		{
			audiolist.shift()
			audio.destroy()
		})
	}

	function playAudioReapeatByDelay(url:string,delay:number)
	{
		let audio=uni.createInnerAudioContext();
		audiolist.push(audio);
		audio.src=(url)
		audio.play()
		audio.onEnded(()=>
		{
			audiolist.shift()
			audio.destroy()
		})
	let i=setInterval(()=>
		{
			let audio=uni.createInnerAudioContext();
			audio.src=(url)
			audiolist.push(audio);
			audio.play()
			audio.onEnded(()=>
			{
				audiolist.shift()
				audio.destroy()
			})
		},delay)
	timeidlist.push(i)
		
	
	}
	function playaudio(url:string)
	{   
		let audio=uni.createInnerAudioContext();
		audio.src=(url)
		audiolist.push(audio);
		console.log(1, " at pages/tool/voicer.uvue:76")
		//audio.autoplay=true;
		audio.play()
		audio.onEnded(()=>
		{
			audiolist.shift()
			audio.destroy()
		})
	}
	function stopall()
	{
		audiolist.forEach((audio:InnerAudioContext)=>{audio.destroy()})
		timeidlist.forEach((timeid:number)=>{clearInterval(timeid)})
	}
	let flag=false;
	function switchplay(url:string,delay:number,method:string)
	{
		
		flag=!flag;
		if(flag)
		{
			if(method=='repd'){playAudioReapeatByDelay(url,delay)}
			else if(method=='sig'){playaudio(url)}
			else if(method=='rep'){playAudioReapeat(url)}
		}
		else{
			stopall()
		}
	}
	onUnload(()=>{
		stopall();
		})

return (): any | null => {

const _component_navigator = resolveComponent("navigator")

  return createElementVNode("view", utsMapOf({ class: "index" }), [
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
    createElementVNode("view", utsMapOf({ class: "menubox" }), [
      createElementVNode("view", utsMapOf({
        class: "menunav",
        onClick: () => {switchplay('/static/voice/杂鱼杂鱼4.WAV',1880,'repd')}
      }), [
        createElementVNode("text", utsMapOf({ class: "menutext" }), " 杂鱼杂鱼(循环) ")
      ], 8 /* PROPS */, ["onClick"]),
      createElementVNode("view", utsMapOf({
        class: "menunav",
        onClick: () => {switchplay('/static/voice/uno2.wav',1880,'sig')}
      }), [
        createElementVNode("text", utsMapOf({ class: "menutext" }), " UNO! ")
      ], 8 /* PROPS */, ["onClick"])
    ])
  ])
}
}

})
export default __sfc__
const GenPagesToolVoicerStyles = [utsMapOf([["index", padStyleMapOf(utsMapOf([["height", "100%"], ["width", "100%"], ["backgroundImage", "linear-gradient(to bottom, #000000, #1A1A1A)"], ["backgroundColor", "rgba(0,0,0,0)"], ["zIndex", -1], ["display", "flex"], ["flexDirection", "column"], ["alignItems", "center"], ["justifyContent", "center"], ["flexWrap", "wrap"]]))], ["Exit", utsMapOf([[".index ", utsMapOf([["zIndex", 200], ["position", "fixed"], ["marginLeft", "5%"], ["marginTop", "3%"], ["width", 100], ["height", 50]])]])], ["ExitText", utsMapOf([[".index .Exit ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "left"]])]])], ["menubox", utsMapOf([[".index ", utsMapOf([["height", "85%"], ["width", "75%"], ["display", "flex"], ["flexDirection", "row"], ["justifyContent", "space-around"], ["alignItems", "center"], ["borderRadius", 15], ["flexWrap", "wrap"], ["borderWidth", 1], ["borderStyle", "solid"], ["borderColor", "#1A1A1A"]])]])], ["menunav", utsMapOf([[".index .menubox ", utsMapOf([["borderRadius", 35], ["maxWidth", 150], ["minWidth", 150], ["height", "40%"], ["borderWidth", 3], ["borderStyle", "solid"], ["borderColor", "#e91e63"], ["boxSizing", "border-box"], ["flex", 1], ["textAlign", "center"], ["flexDirection", "column"], ["justifyContent", "center"], ["alignItems", "center"]])]])], ["menutext", utsMapOf([[".index .menubox .menunav ", utsMapOf([["textWrap", "wrap"], ["fontSize", "30rpx"], ["textAlign", "center"], ["color", "#e91e63"], ["fontFamily", "像素字"]])]])], ["menutitle", padStyleMapOf(utsMapOf([["transform", "translateY(-25%) translateX(-3%)"], ["maxHeight", 50], ["fontSize", 50], ["textAlign", "center"], ["color", "#FFFFFF"], ["fontFamily", "像素字"]]))], ["@FONT-FACE", utsMapOf([["0", utsMapOf([["fontFamily", "像素字"], ["src", "url(\"../static/锐字太空奇遇像素.ttf\")"]])]])]])]
