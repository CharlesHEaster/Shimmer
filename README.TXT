
PROJECT TITLE: Shimmer
PURPOSE OF PROJECT:  An attempt to recreate the "shimmer" bees will 
    perform to protect the hive using a 2D hex grid. 
    Example: https://youtu.be/dU2rLhpaMAY?t=21
DATE: 08-July-2020


Final notes:
I have achieved what I set out to do.  I'm still not happy with the Hex.decernHex() method, I am sure there is a better way to do it.
--Turns out a better way is to make Hex an abstract class and to create a NormHex class.  Then have Hex.decernHex() return a new hex subclass.
I am also sure that I could better orginize some functions and variables into more appropriate classes.
In the future I may revisit this project and try to integrate real time GUI sliders for most of the variables.
If you have any advise or critiques, please pass them on.

TODO: 
    -- create frame rate variable and let user change it
    -- make demo values the default (pre-entered) text value when prompting the user for variable values
    real time GUI variable sliders
