package victor.com.br.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


class InputFragment : Fragment() {

    lateinit var rootView: View
    lateinit var ed1: EditText
    lateinit var ed2: EditText
    lateinit var bt: Button

    fun newInstance(): Fragment {
        return InputFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("APP", "onCreatr")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        super.onCreateView(inflater, container, savedInstanceState)/

        rootView = inflater.inflate(R.layout.fragment_input, container, false)

        ed1 = rootView.findViewById(R.id.editText)
        ed2 = rootView.findViewById(R.id.editText1)
        bt = rootView.findViewById(R.id.button)

        bt.setOnClickListener {

            val action =
                InputFragmentDirections.actionInputToNavigationBillPaymentsConfirmation(
                    "1",
                    "2"
                )
            Navigation.findNavController(rootView).navigate(action)
        }

        return rootView
    }
}