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
open class GenPagesToolVoicer : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesToolVoicer) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesToolVoicer;
            val _cache = __ins.renderCache;
            var audiolist: UTSArray<InnerAudioContext> = utsArrayOf();
            var timeidlist: UTSArray<Number> = utsArrayOf();
            fun genPlayAudioReapeatFn(url: String) {
                var audio = uni_createInnerAudioContext();
                audio.src = url;
                audiolist.push(audio);
                console.log(1);
                audio.play();
                audio.loop = true;
                audio.onEnded(fun(_result){
                    audiolist.shift();
                    audio.destroy();
                }
                );
            }
            val playAudioReapeat = ::genPlayAudioReapeatFn;
            fun genPlayAudioReapeatByDelayFn(url: String, delay: Number) {
                var audio = uni_createInnerAudioContext();
                audiolist.push(audio);
                audio.src = url;
                audio.play();
                audio.onEnded(fun(_result){
                    audiolist.shift();
                    audio.destroy();
                }
                );
                var i = setInterval(fun(){
                    var audio = uni_createInnerAudioContext();
                    audio.src = url;
                    audiolist.push(audio);
                    audio.play();
                    audio.onEnded(fun(_result){
                        audiolist.shift();
                        audio.destroy();
                    }
                    );
                }
                , delay);
                timeidlist.push(i);
            }
            val playAudioReapeatByDelay = ::genPlayAudioReapeatByDelayFn;
            fun genPlayaudioFn(url: String) {
                var audio = uni_createInnerAudioContext();
                audio.src = url;
                audiolist.push(audio);
                console.log(1);
                audio.play();
                audio.onEnded(fun(_result){
                    audiolist.shift();
                    audio.destroy();
                }
                );
            }
            val playaudio = ::genPlayaudioFn;
            fun genStopallFn() {
                audiolist.forEach(fun(audio: InnerAudioContext){
                    audio.destroy();
                }
                );
                timeidlist.forEach(fun(timeid: Number){
                    clearInterval(timeid);
                }
                );
            }
            val stopall = ::genStopallFn;
            var flag = false;
            fun genSwitchplayFn(url: String, delay: Number, method: String) {
                flag = !flag;
                if (flag) {
                    if (method == "repd") {
                        playAudioReapeatByDelay(url, delay);
                    } else if (method == "sig") {
                        playaudio(url);
                    } else if (method == "rep") {
                        playAudioReapeat(url);
                    }
                } else {
                    stopall();
                }
            }
            val switchplay = ::genSwitchplayFn;
            onUnload(fun(){
                stopall();
            }
            );
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator");
                return createElementVNode("view", utsMapOf("class" to "index"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("open-type" to "navigateBack", "animation-type" to "pop-out", "url" to "/pages/index/index", "class" to "Exit"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("selectable" to "false", "class" to "ExitText"), "< 返回")
                        );
                    }
                    ), "_" to 1)),
                    createElementVNode("view", utsMapOf("class" to "menubox"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "menunav", "onClick" to fun(){
                            switchplay("/static/voice/杂鱼杂鱼4.WAV", 1880, "repd");
                        }
                        ), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "menutext"), " 杂鱼杂鱼(循环) ")
                        ), 8, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("view", utsMapOf("class" to "menunav", "onClick" to fun(){
                            switchplay("/static/voice/uno2.wav", 1880, "sig");
                        }
                        ), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "menutext"), " UNO! ")
                        ), 8, utsArrayOf(
                            "onClick"
                        ))
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
                return utsMapOf("index" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "zIndex" to -1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "flexWrap" to "wrap")), "Exit" to utsMapOf(".index " to utsMapOf("zIndex" to 200, "position" to "fixed", "marginLeft" to "5%", "marginTop" to "3%", "width" to 100, "height" to 50)), "ExitText" to utsMapOf(".index .Exit " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "left")), "menubox" to utsMapOf(".index " to utsMapOf("height" to "85%", "width" to "75%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "alignItems" to "center", "borderRadius" to 15, "flexWrap" to "wrap", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#1A1A1A")), "menunav" to utsMapOf(".index .menubox " to utsMapOf("borderRadius" to 35, "maxWidth" to 150, "minWidth" to 150, "height" to "40%", "borderWidth" to 3, "borderStyle" to "solid", "borderColor" to "#e91e63", "boxSizing" to "border-box", "flex" to 1, "textAlign" to "center", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "menutext" to utsMapOf(".index .menubox .menunav " to utsMapOf("textWrap" to "wrap", "fontSize" to "30rpx", "textAlign" to "center", "color" to "#e91e63", "fontFamily" to "像素字")), "menutitle" to padStyleMapOf(utsMapOf("transform" to "translateY(-25%) translateX(-3%)", "maxHeight" to 50, "fontSize" to 50, "textAlign" to "center", "color" to "#FFFFFF", "fontFamily" to "像素字")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"../static/锐字太空奇遇像素.ttf\")")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
