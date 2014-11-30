package org.flightofstairs.adirstat.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import org.flightofstairs.adirstat.Tree;
import org.flightofstairs.adirstat.model.FilesystemSummary;
import org.flightofstairs.adirstat.view.packing.Packing;

public class TreeMap extends Drawable {

    private final Tree<FilesystemSummary> summaryTree;
    private final Packing packing;

    public TreeMap(Tree<FilesystemSummary> summaryTree, Packing packing) {
        this.summaryTree = summaryTree;
        this.packing = packing;
    }

    @Override
    public void draw(Canvas canvas) {
        draw(packing.pack(summaryTree, canvas.getClipBounds()), canvas);
    }

    private static void draw(Tree<DisplayNode> node, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(node.getValue().getBounds(), paint);

        for (Tree<DisplayNode> child : node.getChildren()) {
            draw(child, canvas);
        }
    }

    @Override
    public int getOpacity() {return 0;}

    @Override
    public void setAlpha(int alpha) {}

    @Override
    public void setColorFilter(ColorFilter cf) {}
}
