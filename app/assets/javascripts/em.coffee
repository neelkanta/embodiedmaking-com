@equalHeight = (group, tallest = 0) ->
    group.each(->
        thisHeight = $(this).height()
        if thisHeight > tallest
            tallest = thisHeight
    )

    group.each(->
        $(this).height(tallest)
    )
