<div align="center">
  <h1>Blender CLI Rendering UI Client</h1>

<b>
This tool is to make it easier to render from the command line without having to learn how to use Blender's CLI, making it more user friendly, especially to newer users.
</b>

<a href="https://github.com/IRPCode/Blender-CLI-Rendering-UI-Client/tree/main/blenderCommandLineInterfaceUserInterface/src/blenderCommandLineInterfaceUserInterface">The source code is available here</a>

<a href="https://github.com/IRPCode/Blender-CLI-Rendering-UI-Client/blob/main/blenderCommandLineInterfaceUserInterface/CLIRenderingTool.jar">Download the .jar file here</a>
  
</div>

<div align="center">
<h2>Prerequisites</h2>
</div>

The following programs are required in order for you to run the software:


  - <a href="https://www.blender.org/">Install the latest version of Blender</a>
  - <a href="https://www.java.com/en/">Install the latest version of Java</a>
  - You must be on an up to date version of Windows 11/10

<div align="center">
<h2>How to use the software</h2>
</div>
Make sure Blender is installed to the following location:


    C:\Program Files\Blender Foundation\Blender X.X
- This should be the default location, but it must be here in order to work properly

- After downloading Java from the provided link above, ensure you run the downloadable and follow its instructions


<h2>Running the program</h2>



<div align="center"> 


<b>
This is what the program will look like.
</b>

![image](https://github.com/user-attachments/assets/2afa0dca-21f3-47f7-9861-8879a2bc0070)

</div>

- In the first section, there is a button to open up an integrated file browser retrieve your file. It must be a .blend file in order for the program to work.

<div align="center"> 

![image](https://github.com/user-attachments/assets/f212df0c-ac79-4dbd-9482-e12ac5850fe9)

</div>

- Once selected, you can search for your .blend file. In this case, the shown file below is 1CLIGroundRenderTest.blend.

<div align="center"> 

![image](https://github.com/user-attachments/assets/227aa00c-296e-463d-ac50-8aebdbc6eba9)

</div>

- Afterwards, we have a few sections. Starting off, we have your rendering device. CPU is for CPU rendering, Optix is for Nvidia GPUs, while CUDA is an older platform for Nvidia GPUs
- OneAPI is for Intel GPUs (Intel® Arc™ graphics card with the Xe HPG architecture), HIP is for AMD GPUs, and Metal is for Apple ARM Silicon
- You may want to use CUDA if you are just barely above your VRAM limits, otherwise use CPU render if your scene is too large

<div align="center">

![image](https://github.com/user-attachments/assets/4a24a9ac-f583-4614-907e-b319420ce236)

</div>

- Take note that the program tells you to use the folder that you must use the folder created when Blender is first installed.


<div align="center">

![image](https://github.com/user-attachments/assets/1a4745ee-d179-45b8-a373-4d7924b1a6f5)

</div>

- This is due to Blender overwriting files for smaller updates (4.2 vs 4.2.X). You can identify newer files for larger updates (4.2 vs 4.3), as seen below:

<div align="center">

![image](https://github.com/user-attachments/assets/da4078e0-9a96-4502-9150-843773ecc9b9)

</div>

- You can now select what type of rendering engine you are using. Using scene settings simply uses the rendering engine set in your profile
- Using a different rendering engine sets the rendering engine settings (such as their sample count) to their default settings (Cycles: 4096, EEVEE Next: 64)

<div align="center">

![image](https://github.com/user-attachments/assets/f2c5b161-0ffc-4101-8bc8-956ce6905f17)

</div>

- You can set Blender's CLI rendering client to render a specific frame, or a set of frames

<div align="center">

![image](https://github.com/user-attachments/assets/e7adf145-84af-4048-a441-e2fae502734b)


![image](https://github.com/user-attachments/assets/b0903037-7bb2-4094-8e8f-f7c1fac90fa4)


</div>

- Once done, you can render your image!

![image](https://github.com/user-attachments/assets/094d5955-6e40-4a81-923d-ea7aac039556)

<div align="center">
<h2>The Command Line</h2>
</div>

- Once you hit the 'Render!' button, the program will do two things:
  - It will open up the command line
  - It will open up the C:\tmp folder (This is where your images will be outputted to)

<div align="center">

![image](https://github.com/user-attachments/assets/80b0dd37-1b5a-4f84-bc8e-fb1c1e1fce38)

</div>

- Finally, you can take a look at your rendered image!

<div align="center">

![1Peak-1334-38M-07-54-92-CLI](https://github.com/user-attachments/assets/fead7ebb-7316-46eb-ab25-f7ed197d50bf)

</div>


<div align="center">
<h2>Why CLI Rendering?</h2>
</div>

Command line rendering has a few advantages over rendering within Blender:
- It does not have to update any GUIs, so it uses less memory and renders slightly faster
- Due to this, it is also more stable with larger scenes, and is significantly less prone to crashing


From testing, here are a few results from rendering in Blender, and rendering from the CLI.
All tests were using the Cycles rendering engine with default settings, and the resolution (2560 x 1600).

<hr></hr>

- Test 1:

<div align="center">

![1Peak-1334-38M-07-54-92-CLI](https://github.com/user-attachments/assets/fead7ebb-7316-46eb-ab25-f7ed197d50bf)

</div>

  - CLI: (Mem): 1334.38MB, (Time): 07.54.92
  - In Blender: (Mem): 1542.92MB, (Time): 08.08.42

<hr></hr>

- Test 2:

<div align="center">

![2Peak-320-14M-05-05-55-CLI](https://github.com/user-attachments/assets/9d6578f1-510e-4fdf-a9ff-0207dbd2dd98)

</div>


  - CLI: (Mem): 320.14MB, (Time): 05.05.55
  - In Blender: (Mem): 560.84MB, (Time): 05.04.84
    - Time is not always faster, but it usually is in most instances

<hr></hr>

- Test 3:

<div align="center">

![3Peak-863-80M-36-30-91-CLI](https://github.com/user-attachments/assets/e469711c-b6ec-48b3-8040-1edc4db3e341)

</div>

  - CLI: (Mem): 863.80MB, (Time): 36.30.91
  - In Blender: (Mem): 1179.24MB, (Time): 36.31.03

<hr></hr>

<div align="center">
<b>
Test Machine Specs:
</b>
</div>

- Processor: AMD Ryzen 7 7745HX
- Memory: 32GB DDR5 5200 MT/s 
- GPU: Mobile RTX 4060
