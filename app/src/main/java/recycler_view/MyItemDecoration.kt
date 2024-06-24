package recycler_view

import android.graphics.Rect
import android.view.View
import androidx.compose.ui.unit.Dp
import androidx.recyclerview.widget.RecyclerView

class MyItemDecoration(val value: Dp): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position % 2 == 0) {
            outRect.left = 50
        } else {
            outRect.right = 50
        }
    }
}