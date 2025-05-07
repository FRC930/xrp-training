# Programming instructions
* Put programming instructions here

|Link|Description|
|:---:|:---:|
|[WPILib instructions](https://docs.wpilib.org/en/stable/docs/xrp-robot/programming-xrp.html)| WPILib instructions for flashing the XRP and creating the project|

## Flashing the board 
**Make sure that you have a USB data cable!**
1. Extract the contents of the firmware ZIP file. You should end up with a .uf2 file.
2. Plug the XRP into your computer with a Micro-USB cable. You should see a red power LED that lights up.
3. While holding the BOOTSEL button, quickly press the reset button, and then release the BOOTSEL button.
4. The board will temporarily disconnect from your computer, and then reconnect as a USB storage device named RPI-RP2.
5. Drag the .uf2 firmware file into the RPI-RP2 drive, and it will automatically update the firmware.
6. Once complete, the RPI-RP2 USB storage device will disconnect. At this point, you can disconnect the XRP board from your computer and run it off battery power.