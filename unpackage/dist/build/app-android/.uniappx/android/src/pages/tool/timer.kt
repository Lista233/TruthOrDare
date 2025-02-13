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
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesToolTimer : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesToolTimer) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesToolTimer;
            val _cache = __ins.renderCache;
            fun genPadWithZerosFn(num: Number, length: Number): String {
                var numStr = num.toString(10);
                var zerosToPad = length - numStr.length;
                if (zerosToPad > 0) {
                    numStr = "0".repeat(zerosToPad) + numStr;
                }
                return numStr;
            }
            val padWithZeros = ::genPadWithZerosFn;
            var totalmsec = ref(5000);
            var sec = computed(fun(): Number {
                return Math.floor(totalmsec.value / 1000);
            }
            );
            var msec = computed(fun(): Number {
                return totalmsec.value % 1000;
            }
            );
            var timerdelay: Number = 2;
            var intervalID: Number = -1;
            var tid: Number = -1;
            var settingtime = totalmsec.value;
            var isStart = false;
            var firsttouch = true;
            var showsec = computed(fun(): String {
                return padWithZeros(sec.value as Number, 2);
            }
            );
            var showmsec = computed(fun(): String {
                return padWithZeros(msec.value as Number, 3);
            }
            );
            fun genStopFn(): Boolean {
                clearInterval(intervalID);
                return true;
            }
            val stop = ::genStopFn;
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
            fun genStartFn() {
                isStart = !isStart;
                if (firsttouch) {
                    if (totalmsec.value <= 0) {
                        totalmsec.value = settingtime;
                    }
                    console.log(3);
                    playaudio("/static/voice/计时开始了呦.wav");
                    firsttouch = false;
                }
                if (isStart) {
                    intervalID = setInterval(fun(){
                        totalmsec.value = if (totalmsec.value - timerdelay >= 0) {
                            totalmsec.value - timerdelay;
                        } else {
                            0;
                        };
                        if (totalmsec.value == 0) {
                            stop();
                            console.log(1);
                            if (tid != -1) {
                                clearTimeout(tid);
                            }
                            tid = setTimeout(fun(){
                                playaudio("/static/voice/计时结束.wav");
                            }
                            , 50);
                            firsttouch = true;
                            isStart = false;
                            return;
                        }
                    }, timerdelay);
                } else {
                    if (!firsttouch) {
                        playaudio("/static/voice/暂停.wav");
                    }
                    clearInterval(intervalID);
                }
            }
            val start = ::genStartFn;
            fun genChangeTimeFn() {
                var op = ShowModalOptions(title = "修改时间（单位：秒）", editable = true, fail = null, success = fun(res){
                    if (res.cancel) {
                        return;
                    }
                    console.log("我成功了");
                    var content = res.content?.trim();
                    var a = parseInt(content!!);
                    if (a == NaN || a < 0) {
                        uni_showToast(ShowToastOptions(title = "请输入正整数", icon = "none", position = "bottom"));
                        return;
                    } else {
                        totalmsec.value = a * 1000;
                        settingtime = a * 1000;
                    }
                }
                );
                var a = uni_showModal(op);
            }
            val changeTime = ::genChangeTimeFn;
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator");
                return createElementVNode("view", utsMapOf("class" to "timer"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("open-type" to "navigateBack", "animation-type" to "pop-out", "url" to "/pages/index/index", "class" to "Exit"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("selectable" to "false", "class" to "ExitText"), "< 返回")
                        );
                    }
                    ), "_" to 1)),
                    createElementVNode("text", utsMapOf("onClick" to fun(){
                        start();
                    }
                    , "class" to "timertext"), toDisplayString(unref(showsec)) + ":" + toDisplayString(unref(showmsec)), 9, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("text", utsMapOf("onClick" to fun(){
                        changeTime();
                    }
                    , "class" to "settimertext"), " 设置时间", 8, utsArrayOf(
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
                return utsMapOf("timer" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "zIndex" to -1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "flexWrap" to "wrap")), "Exit" to utsMapOf(".timer " to utsMapOf("zIndex" to 200, "position" to "fixed", "marginLeft" to "5%", "marginTop" to "3%", "width" to 100, "height" to 50)), "ExitText" to utsMapOf(".timer .Exit " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "left")), "timertext" to utsMapOf(".timer " to utsMapOf("fontFamily" to "像素字", "fontSize" to 50, "color" to "#F5DEB3")), "settimertext" to utsMapOf(".timer " to utsMapOf("fontFamily" to "像素字", "fontSize" to 35, "color" to "#FFFFFF", "zIndex" to 1, "position" to "fixed", "right" to 30, "bottom" to 5, "marginTop" to "4%", "height" to 50)), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"../static/锐字太空奇遇像素.ttf\")")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
