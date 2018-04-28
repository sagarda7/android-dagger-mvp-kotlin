package np.com.sagardevkota.daggertemplate.ui.views

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.TextView

import com.tealbox.app.R


class CustomProgressDialog : AlertDialog {
    internal var message: String? = null
    internal var txtMessage: TextView? = null

    constructor(context: Context) : super(context) {
        // TODO Auto-generated constructor stub
    }

    constructor(context: Context, theme: Int) : super(context, theme) {
        // TODO Auto-generated constructor stub
    }

    constructor(context: Context, cancelable: Boolean,
                cancelListener: DialogInterface.OnCancelListener) : super(context, cancelable, cancelListener) {
        // TODO Auto-generated constructor stub
    }

    override fun show() {
        // TODO Auto-generated method stub
        super.show()
        setContentView(R.layout.dialog_progress)
        txtMessage = findViewById<TextView>(
                R.id.text_view_progress_message)

    }

    fun message(message: String): CustomProgressDialog {
        this.message = message
        return this
    }

    fun setMessage(message: String) {
        this.message = message
        txtMessage?.text = this.message
        //return this;
    }


}
