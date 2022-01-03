package kd.exo.videoplayerlist

import com.bumptech.glide.RequestManager

import android.view.View
import android.widget.*

import androidx.recyclerview.widget.RecyclerView


class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var media_container: FrameLayout
    var title: TextView
    var thumbnail: ImageView
    var volumeControl: ImageView
    var progressBar: ProgressBar
    var parent: View
    var requestManager: RequestManager? = null
    var playBtn: Button
    var posInList = -1

    fun onBind(mediaObject: MediaObject, requestManager: RequestManager?, index: Int) {
        this.requestManager = requestManager
        posInList = index
        playBtn.tag = index
        parent.tag = this
        title.text = mediaObject.title
        this.requestManager?.load(mediaObject.thumbnail)?.into(thumbnail)
    }

    init {
        parent = itemView
        media_container = itemView.findViewById(R.id.media_container)
        thumbnail = itemView.findViewById(R.id.thumbnail)
        title = itemView.findViewById(R.id.title)
        progressBar = itemView.findViewById(R.id.progressBar)
        volumeControl = itemView.findViewById(R.id.volume_control)
        playBtn = itemView.findViewById(R.id.playBtn)
    }
}