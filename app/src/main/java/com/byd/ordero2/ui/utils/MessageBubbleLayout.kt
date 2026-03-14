package com.byd.ordero2.ui.utils


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.byd.ordero2.R


class MessageBubbleLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#A9D4EE")
    }

    private val bubblePath = Path()
    private val roundRectPath = Path()
    private val cutPath = Path()

    private var cornerRadius = dp(28f)
    private var cutRadius = dp(32f)

    init {
        setWillNotDraw(false)

        context.withStyledAttributes(attrs, R.styleable.MessageBubbleLayout) {
            paint.color = getColor(
                R.styleable.MessageBubbleLayout_bubbleColor,
                Color.parseColor("#A9D4EE")
            )
            cornerRadius = getDimension(
                R.styleable.MessageBubbleLayout_bubbleCornerRadius,
                dp(28f)
            )
            cutRadius = getDimension(
                R.styleable.MessageBubbleLayout_bubbleCutRadius,
                dp(32f)
            )
        }

        // Чтобы дети не рисовались вне формы
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        bubblePath.reset()
        roundRectPath.reset()
        cutPath.reset()

        val rect = RectF(0f, 0f, width.toFloat(), height.toFloat())

        // Основная форма пузыря
        roundRectPath.addRoundRect(
            rect,
            floatArrayOf(
                cornerRadius, cornerRadius,
                cornerRadius, cornerRadius,
                cornerRadius, cornerRadius,
                cornerRadius, cornerRadius
            ),
            Path.Direction.CW
        )

        cutPath.addCircle(
            -cutRadius * 0.15f,
            cutRadius * 1.05f,
            cutRadius,
            Path.Direction.CW
        )

        bubblePath.op(roundRectPath, cutPath, Path.Op.DIFFERENCE)

        canvas.drawPath(bubblePath, paint)
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save = canvas.save()

        if (!bubblePath.isEmpty) {
            canvas.clipPath(bubblePath)
        }

        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    private fun dp(value: Float): Float {
        return value * resources.displayMetrics.density
    }
}