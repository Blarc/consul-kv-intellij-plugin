import com.intellij.DynamicBundle
import com.intellij.ide.browsers.BrowserLauncher
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey
import java.net.URI

@NonNls
private const val BUNDLE = "messages.MyBundle"

object ConsulKVBundle : DynamicBundle(BUNDLE) {

    val URL_BUG_REPORT = URI("https://github.com/Blarc/consul-kv-intellij-plugin/issues").toURL()

    @Suppress("SpreadOperator")
    @JvmStatic
    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
            getMessage(key, *params)

    @Suppress("SpreadOperator", "unused")
    @JvmStatic
    fun messagePointer(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
            getLazyMessage(key, *params)

    fun openRepository() {
        BrowserLauncher.instance.open("https://github.com/Blarc/ai-commits-intellij-plugin");
    }


}
