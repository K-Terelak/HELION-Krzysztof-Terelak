package kt.mobile.helion_krzysztof_terelak2.fragment.home.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import kt.mobile.helion_krzysztof_terelak2.databinding.MyDialogLayoutBinding

class ShowDetailsDialog : DialogFragment() {

    private val args by navArgs<ShowDetailsDialogArgs>()

    private var _binding: MyDialogLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MyDialogLayoutBinding.inflate(inflater, container, false)

        binding.category = args.category
        binding.executePendingBindings()

        return binding.root
    }
}