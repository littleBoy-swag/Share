package cn.nqy.share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import cn.nqy.base.NqyShare
import cn.nqy.base.share_type.ShareImageType
import cn.nqy.base.share_type.ShareRichTextType
import cn.nqy.share_dingding.DingDingShare
import cn.nqy.share_dingding.DingdingShareConfig
import cn.nqy.share_qq.QQShareConfig
import cn.nqy.share_qq.QShare
import cn.nqy.share_qq.share_type.QQShareRichTextType

class MainActivity : AppCompatActivity() {

    private val jump =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

    private val customJump = registerForActivityResult(CustomActivityResultContract()) {
        // 返回值是Int类型的
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!BuildConfig.DEBUG) {
            jump.launch(Intent(this, MainActivity::class.java))
        }
    }

    fun startShare(view: View) {
        NqyShare
            .get(QShare(QQShareConfig.newBuilder()
                .setQPlatform(QQShareConfig.Q_PLATFORM_QZONE)
                .setShareType(QQShareRichTextType("https://www.baidu.com", "打开百度", "点击以打开百度"))
                .create()))
            .share(this)
    }
}