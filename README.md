# SoupProject-JavaRewrite

As seen [here](https://youtu.be/uSPG51UXmLo)
---
Soup Project in all its glory. Better in every way than the [Python version](https://github.com/0ak0/SoupProject) I made.

I completely understand that the way I handle files here is terrible. It works though, so out of fear of breaking things I am leaving it as is.
To ensure it works on a different computer, keep the file structure the same.

Like the Python version, this creates images of soup cans with randomly colored bodies, gradient backgrounds, and decal stickers.
Unlike the Python version, this creates images fast (goodbye Turtle, don't know why I was using you), the stickers part is functional, and this doesn't require any odd things.

---

### Usage

Main Builder Program (`builder.java`)<br>
`java builder n`
> Generates full images of the cans, with all features. n is the number of images to make. If an argument is not given, one image will be generated. Files saved to `(root folder)/output`

Background Gradient Generator (`background.java`)<br>
`java background`
> Generates a random vertically linear gradient. Saves this to `(root folder for class file)/imageout`

Can Colorizer (`canbody.java`)<br>
`java builder hexcode`
> Sets a color for the can body. The hexcode argument takes a hexadecimal color value to create a can body from. Saves this to `root folder for class file)/imageout`

Sticker Generator (`decals.java`)<br>
`java decals n`
> Generates a random set of decals/stickers with a random color each. n is the number of stickers to use (0-8) Saves this to `(root folder for class file)/imageout`

