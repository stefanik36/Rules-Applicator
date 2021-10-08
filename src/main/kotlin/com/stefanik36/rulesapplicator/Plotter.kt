package com.stefanik36.rulesapplicator

import space.kscience.dataforge.meta.invoke
import space.kscience.plotly.Plotly
import space.kscience.plotly.makeFile
import space.kscience.plotly.models.Bar
import space.kscience.plotly.models.BarMode

class Plotter(
    private val initialValue: Long,
    private val results: List<Long>
) {

    fun plot() {
        val trace = Bar {
            x.set(1..results.size)
            y.set(results)
            marker {
                color("rgb(55, 83, 109)")
            }
        }

        val plot = Plotly.plot {
            traces(trace)

            layout {
                title = "Initial value: $initialValue"
                val darkBlue = "rgb(107, 107, 107)"
                xaxis {
                    tickfont {
                        color(darkBlue)
                    }
                }
                yaxis {
                    title {
                        text = "value"
                        font {
                            color(darkBlue)
                        }
                    }
                    tickfont {
                        color(darkBlue)
                    }
                }

                barmode = BarMode.group
            }
        }
        plot.makeFile()
    }
}
