@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI00DFA61;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.createInnerAudioContext as uni_createInnerAudioContext;
import io.dcloud.uniapp.extapi.getStorageInfoSync as uni_getStorageInfoSync;
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet;
open class GenPagesGameStart : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesGameStart) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesGameStart;
            val _cache = __ins.renderCache;
            var firstStart = ref(true);
            var keylist = uni_getStorageInfoSync().keys;
            var curshow = ref(keylist[0]);
            var list = uni_getStorageSync(curshow.value) as UTSArray<String>;
            var wordList = ref(list);
            var showView = ref("Press Start");
            var flag = false;
            var timerid: Number = 0;
            var index: Number = 0;
            var textChange = ref(false);
            var isClicked = ref(false);
            var radlist = getApp().globalData.randomlist;
            fun genPlayaudioFn(url: String) {
                var audio = uni_createInnerAudioContext();
                audio.src = url;
                console.log(1);
                audio.play();
                audio.onEnded(fun(_result){
                    audio.destroy();
                }
                );
            }
            val playaudio = ::genPlayaudioFn;
            onHide(fun(){
                console.log("hide");
                flag = false;
                clearInterval(timerid);
            }
            );
            onUnload(fun(){
                console.log("unload");
                flag = false;
                clearInterval(timerid);
            }
            );
            fun genRollFn() {
                if (firstStart.value) {
                    firstStart.value = !firstStart.value;
                }
                console.log(1);
                flag = !flag;
                isClicked.value = flag;
                if (flag) {
                    playaudio("/static/voice/开始.wav");
                    timerid = setInterval(fun(){
                        console.log(index);
                        index = (index + 1) % wordList.value.length;
                        showView.value = wordList.value[index];
                    }, 100);
                } else {
                    if (radlist.length >= wordList.value.length) {
                        radlist.length = 0;
                    }
                    clearInterval(timerid);
                    var rad = Math.floor(Math.random() * wordList.value.length);
                    while(radlist.includes(rad)){
                        rad = (rad + 1) % wordList.value.length;
                    }
                    console.log(radlist);
                    console.log("rad:" + rad);
                    showView.value = wordList.value[rad];
                    textChange.value = true;
                    console.log("index:" + rad + "value:" + wordList.value[rad]);
                    radlist.push(rad);
                    playaudio("/static/voice/抽取结束.wav");
                    setTimeout(fun(){
                        textChange.value = false;
                    }
                    , 100);
                }
            }
            val roll = ::genRollFn;
            fun genShowListFn() {
                var op = ShowActionSheetOptions(itemList = keylist, success = fun(res){
                    curshow.value = keylist[res.tapIndex!!];
                    wordList.value = uni_getStorageSync(curshow.value) as UTSArray<String>;
                }
                );
                uni_showActionSheet(op);
            }
            val showList = ::genShowListFn;
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator");
                return createElementVNode("view", utsMapOf("class" to "demo2"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("open-type" to "navigateBack", "animation-type" to "pop-out", "url" to "/pages/index/index", "class" to "Exit"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("selectable" to "false", "class" to "ExitText"), "< 返回")
                        );
                    }
                    ), "_" to 1)),
                    createElementVNode("view", utsMapOf("class" to "sel", "onClick" to fun(){
                        showList();
                    }
                    ), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "selText"), "当前列表:" + toDisplayString(unref(curshow)), 1)
                    ), 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("view", utsMapOf("class" to "showtext", "onClick" to fun(){
                        roll();
                    }
                    ), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "textbox"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                "textcontent",
                                utsMapOf("textcontentchange" to unref(textChange))
                            )), "selectable" to "false"), toDisplayString(unref(showView)), 3)
                        ))
                    ), 8, utsArrayOf(
                        "onClick"
                    ))
                ));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        };
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("demo2" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "zIndex" to -1)), "Exit" to utsMapOf(".demo2 " to utsMapOf("zIndex" to 200, "position" to "fixed", "marginLeft" to "6%", "marginTop" to "4%", "width" to 100, "height" to 50)), "ExitText" to utsMapOf(".demo2 .Exit " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "center")), "sel" to utsMapOf(".demo2 " to utsMapOf("zIndex" to 1, "position" to "fixed", "right" to "29%", "marginTop" to "3%", "width" to 300, "height" to 50)), "selText" to utsMapOf(".demo2 .sel " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "center")), "showtext" to utsMapOf(".demo2 " to utsMapOf("transitionDuration" to "500ms", "transitionProperty" to "transform", "height" to 200, "width" to 600, "borderWidth" to 5, "borderStyle" to "solid", "borderColor" to "#1A1A1A", "borderTopLeftRadius" to 20, "borderTopRightRadius" to 50, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 50, "boxShadow" to "4px 3px 4px #e91e63", "position" to "relative")), "textbox" to utsMapOf(".demo2 .showtext " to utsMapOf("position" to "absolute", "width" to "100%", "height" to "100%", "display" to "flex", "justifyContent" to "center", "alignContent" to "center")), "textcontent" to utsMapOf(".demo2 .showtext .textbox " to utsMapOf("position" to "absolute", "boxSizing" to "border-box", "width" to "100%", "maxHeight" to 500, "color" to "#FFFFFF", "lineHeight" to "50px", "fontFamily" to "像素字", "fontSize" to 45, "textAlign" to "center", "transitionProperty" to "transform,opacity", "transitionDuration" to "700ms", "opacity" to 1, "transitionDelay" to "0ms", "transitionTimingFunction" to "ease-out")), "textcontentchange" to utsMapOf(".demo2 .showtext .textbox " to utsMapOf("position" to "absolute", "boxSizing" to "border-box", "width" to "100%", "maxHeight" to 500, "lineHeight" to "45px", "fontFamily" to "像素字", "textAlign" to "center", "opacity" to 0.5, "transitionProperty" to "transform", "transitionDuration" to "50ms", "transitionDelay" to "0ms", "transitionTimingFunction" to "ease-out", "transform" to "scale(1.6, 1.6)")), "showtextHover" to utsMapOf(".demo2 .showtext " to utsMapOf("transitionDuration" to "500ms", "height" to "100%", "width" to "100%", "borderWidth" to 5, "borderStyle" to "solid", "borderColor" to "#1A1A1A", "borderTopLeftRadius" to 20, "borderTopRightRadius" to 50, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 50, "boxShadow" to "4px 3px 4px #e91e63", "position" to "relative", "backgroundColor" to "#e91e63", "transform" to "scale(0.8, 0.8)")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"../static/锐字太空奇遇像素.ttf\")")), "@TRANSITION" to utsMapOf("showtext" to utsMapOf("duration" to "500ms", "property" to "transform"), "textcontent" to utsMapOf("property" to "transform,opacity", "duration" to "700ms", "delay" to "0ms", "timingFunction" to "ease-out"), "textcontentchange" to utsMapOf("property" to "transform", "duration" to "50ms", "delay" to "0ms", "timingFunction" to "ease-out"), "showtextHover" to utsMapOf("duration" to "500ms")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
