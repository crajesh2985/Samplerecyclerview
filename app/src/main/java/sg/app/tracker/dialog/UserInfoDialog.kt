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


class UserInfoDialog(val clickListener: (LoanDetails) -> Unit) : DialogFragment() {

    private var content: String? = null

    var toolNameValue =""
    var friendName = "Brian"


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
        val view = inflater!!.inflate(R.layout.dialog_user_info, container, false)

        val submitBtn:Button = view.findViewById(R.id.btn_submit)as Button
        val cancelBtn:Button = view.findViewById(R.id.btn_cancel)as Button


        val radioGroup:RadioGroup = view.findViewById(R.id.rg_friend_group)as RadioGroup


        toolNameValue = arguments?.getString("toolName")!!


        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rb_brian) {
                //do work when radioButton1 is active
                friendName = "Brian"
            } else if (checkedId == R.id.rb_luke) {
                //do work when radioButton2 is active
                friendName = "Luke"
            } else if (checkedId == R.id.rb_letty) {
                //do work when radioButton3 is active
                friendName = "Letty"
            }else if (checkedId == R.id.rb_shaw) {
                //do work when radioButton3 is active
                friendName = "Shaw"
            }else if (checkedId == R.id.rb_parker) {
                //do work when radioButton3 is active
                friendName = "Parker"
            }
        })


        submitBtn.setOnClickListener {
            val loanDetails = LoanDetails( toolNameValue, friendName)
            clickListener(loanDetails)
            dismiss()
        }

        cancelBtn.setOnClickListener {
            dismiss()
        }


        return view
    }

    companion object {
        fun newInstance(content: String, clickListener: (LoanDetails) -> Unit): UserInfoDialog {
            val f = UserInfoDialog(clickListener)
            val args = Bundle()
            args.putString("toolName", content)
            f.arguments = args
            return f
        }
    }

}