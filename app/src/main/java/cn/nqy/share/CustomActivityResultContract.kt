package cn.nqy.share

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * ActivityResultContract的第一个泛型参数代表输入的参数类型，第二个泛型参数代表输出的参数类型
 */
class CustomActivityResultContract : ActivityResultContract<String, Int>() {
    override fun createIntent(context: Context, input: String?): Intent {
        return Intent()
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Int {
        return 1
    }
}