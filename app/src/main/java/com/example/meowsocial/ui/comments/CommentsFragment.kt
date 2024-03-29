package com.example.meowsocial.ui.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meowsocial.R
import com.example.meowsocial.comments.adapter.CommentsAdapter
import com.example.meowsocial.databinding.FragmentCommentsBinding
import com.example.meowsocial.ui.comments.CommentsViewModel


class CommentsFragment: Fragment() {

    private var _binding: FragmentCommentsBinding? = null
    private val binding get() = _binding!!


    private val args: CommentsFragmentArgs by navArgs()
    private val postId by lazy { args.postId }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //TODO: use postId
        // Здесь заполняем
        val commentsProvider =  ViewModelProvider(this).get(CommentsViewModel::class.java)
        commentsProvider.loadComments(postId)
        val adapter = CommentsAdapter()
        val commentsView: RecyclerView = binding.commentsFeed
        commentsView.layoutManager = LinearLayoutManager(context)
        commentsView.adapter = adapter


        commentsProvider.comments.observe(viewLifecycleOwner) {
            adapter.updateComments(it)
        }
        // обрабатываем возврат на главную страницу
        onBackLayoutPress()
    }

    private fun onBackLayoutPress(){
        val backLayout = binding.commentsBlockNavigateBack
        backLayout.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.navigation_home)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}