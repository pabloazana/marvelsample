MultipleHeaderRecyclerView
==============================
Just a way to manage multiple sections with different heads and different ViewHolder inside the same RecyclerView, Thanks to [Dario Martín] (https://twitter.com/darymlo), a crack in Android UI and fanatic of Material Design.

What is it?
-------------
__MultipleHeaderRecyclerView__ is a library for allowing you to create a RecyclerView with differents kind of sections (ViewHolders) and it's own titles in an easy way. As you can see in the example below, we have a RecyclerView with three differents kind of sections (Event, Comic and Character) and it's own titles:


![alt text](https://github.com/pabloazana/marvelsample/raw/master/multipleheaderrecyclerview/doc/ezgif.com-video-to-gif.gif "MultipleHeaderRecyclerView example")

Why?
------
Because I would like to provide an easy way to create one of this elements __without need to override__ the same methods again. I've created this __generic module__ which we could use in differents projects.

How?
------
For using MultipleHeaderRecyclerView you should follow the next steps:

* Import the MultipleHeaderRecycleView module (sorry for the obvious).
* Make the models you want to use __extends__ from __RecycleBaseModel__
* __Asign a type__ to the model. This type should be and Integer starting by 0 and it will __stablish the order__. In our example Event is the type 0, Comic the type 1 and Character the type 2.
* Create your __adapter__ extending from __RecycleBaseAdapter__ and override its methods.
* Create as much __ViewHolders__ as you need extending from __HeaderAndItemViewHolder__

In the example code you can see how I've used the module. In this [post] (http://www.agiledeveloper.ninja/2015/06/recyclerviews-with-multiple-sections.html) of my blog, you can find more details about.

Contribute, carajo!
-------------------
Please, I'm quite sure that we can do it in a more __efficient__ and __easy way__. Feel free to __contribute__!

License
-------
This project is licensed under the Apache Software License, Version 2.0.

    Copyright (c) 2015 Pablo Azaña

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
