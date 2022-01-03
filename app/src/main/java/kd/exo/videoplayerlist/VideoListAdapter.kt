package kd.exo.videoplayerlist

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater

import android.view.ViewGroup
import com.bumptech.glide.RequestManager


class VideoListAdapter(
    private val mediaObjects: List<MediaObject>,
    private val requestManager: RequestManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

//    private val mediaObjects: List<MediaObject>
//    private val requestManager: RequestManager

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        return VideoPlayerViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.layout_video_list_item, viewGroup, false)
        )
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        (viewHolder as VideoPlayerViewHolder).onBind(mediaObjects[i], requestManager, i)
    }

    override fun getItemCount(): Int {
        return mediaObjects.size
    }

//    init {
//        this.mediaObjects = mediaObjects
//        this.requestManager = requestManager
//    }
}