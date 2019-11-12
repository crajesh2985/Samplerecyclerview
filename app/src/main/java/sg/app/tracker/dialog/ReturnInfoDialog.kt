package sg.app.tracker.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import sg.app.tracker.LoanDetails
import sg.app.tracker.R


class ReturnInfoDialog(val clickListener: (LoanDetails) -> Unit) : DialogFragment() {

    private var content: String? = null

    var toolNameValue =""
    var friendNameValue = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments?.getString("content")
        val style = DialogFragment.STYLE_NO_FRAME
        val theme = R.style.Theme_AppCompat_Dialog_Alert
        setStyle(style, theme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater!!.inflate(R.layout.dialog_return_info, container, false)

        val submitBtn:Button = view.findViewById(R.id.btn_submit)as Button
        val cancelBtn:Button = view.findViewById(R.id.btn_cancel)as Button



        toolNameValue = arguments?.getString("toolName")!!
        friendNameValue = arguments?.getString("friendName")!!

        submitBtn.setOnClickListener {
            val loanDetails = LoanDetails( toolNameValue, friendNameValue)
            clickListener(loanDetails)
            dismiss()
        }

        cancelBtn.setOnClickListener {
            dismiss()
        }


        return view
    }

    companion object {
        fun newInstance(toolName: String, friendName: String,clickListener: (LoanDetails) -> Unit): ReturnInfoDialog {
            val f = ReturnInfoDialog(clickListener)
            val args = Bundle()
            args.putString("toolName", toolName)
            args.putString("friendName", friendName)
            f.arguments = args
            return f
        }
    }

}