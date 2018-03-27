# Form-48-Tracker
Simple tracking system

**UPDATE** UI_ver1.1 -  Implemented a checkbox feature, which will work in conjunction with the delete to allow fields no longer in use to be deleted. Line 23 and Line 28, Created an label object to be used as an empty label placholder to even out the text field label names. Lines 42-43 allow text boxes to be created in the empty placeholder column along side the textfields.

**UPDATE** UI_ColorRenderer - Changes made to the project are the removal of the original checkbox system in favor of a simple (Yes or No) option. This portion of the project is to implement the DefaultCellRenderer method into the GUI to take the 'Turned in?' col as an argument to determine the status of the users form.
 
**UPDATE** 21 March 2018 UI_ColorRenderer or Gui is updated to reflect the subclass implementation of the custom renderer. I also added the RowColorRendere.java file that adds the beta custom cell renderer class.

**UPDATE** 22 March 2018 UI_ColorRenderer, I updated the GUI layout, by placing the components in a (Stacke) type layout,making for (in my opinion) a better looking gui. A title was added above the User Input fields, and the User input fields  have nammes/lables beside them for easier recognition. Overall 'QOL' (Qualitly of Life) changes were made. for the RowColorRenderer file, the overall main function has been corrected. Now when "Yes" is checked, while the row doesn't highlight green as intended, the particular cell the user clicks yes in does. The current function allows for better tracking.
**UPDATE** 27 March 2018 UI_ColorRenderer, add a (Load Button) replacing the delete. Currently adding the 'read and write' functionality to txt docs for continuity purposes currently **STILL IN PROGRESS**
