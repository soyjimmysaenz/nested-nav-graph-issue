package cl.sosafe.nestednavdemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import cl.sosafe.nestednavdemo.R
import cl.sosafe.nestednavdemo.UserNavGraphDirections

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup(view)
    }

    private fun setup(rootView: View) {
        rootView.findViewById<Button>(R.id.buttonUserProfile)?.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeToUserNavGraph())
        }

        rootView.findViewById<Button>(R.id.buttonUserSettings1)?.setOnClickListener {
            val linkRequest = NavDeepLinkRequest.Builder
                .fromUri("sosafedemo://user_settings".toUri())
                .build()
            findNavController().navigate(linkRequest)
        }

        //val globalNavController = Navigation.findNavController(requireActivity(), R.id.home_nav_host_fragment)

        rootView.findViewById<Button>(R.id.buttonUserSettings2)?.setOnClickListener {
            findNavController().navigate(R.id.userSettingsFragment)
        }

        rootView.findViewById<Button>(R.id.buttonUserSettings3)?.setOnClickListener {
            findNavController().navigate(UserNavGraphDirections.actionGlobalUserSettingsFragment())
        }
    }
}