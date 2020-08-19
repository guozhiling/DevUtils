package dev.base.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import dev.base.able.IDevBaseViewBinding
import dev.base.fragment.DevBaseFragment
import dev.base.utils.ViewBindingUtils

/**
 * detail: Fragment ViewBinding 基类
 * @author Ttt
 */
abstract class DevBaseViewBindingFragment<VB : ViewBinding> : DevBaseFragment(),
    IDevBaseViewBinding<VB> {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // ViewBinding 初始化处理
        _binding = viewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun viewBinding(inflater: LayoutInflater, container: ViewGroup?): VB {
        return ViewBindingUtils.viewBinding(
            inflater,
            container,
            getBindingView(),
            javaClass
        )
    }

    override fun getBindingView(): View? {
        return null
    }
}