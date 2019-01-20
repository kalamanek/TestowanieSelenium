package testy.pageObject.dragAndDropDemo;


import java.nio.file.Files;
import java.nio.file.Paths;


import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.data.Data;
import testy.pageObject.*;

public final class DragAndDropDemo extends BasePage{

	@FindBy(xpath = ("//div[@id='mydropzone']"))
	private WebElement container;
	
	@FindBy(xpath = ("//span[contains(text(),'Draggable 1')]"))
	private WebElement draggable1;	
	
	@FindBy(xpath = ("//span[contains(text(),'Draggable 2')]"))
	private WebElement draggable2;	
	
	@FindBy(xpath = ("//span[contains(text(),'Draggable 3')]"))
	private WebElement draggable3;	
	
	@FindBy(xpath = ("//span[contains(text(),'Draggable 4')]"))
	private WebElement draggable4;

	public DragAndDropDemo(WebDriver driver) {
		super(driver);
		childUrl = "drag-and-drop-demo.html";
	}
	
	@Override
	public void openChildPage() throws InvalidArgumentException{
		{
		    try{       
		        driver.get(Data.mainUrl + childUrl);
		    }catch(InvalidArgumentException e){
		        System.out.println(Data.mainUrl + childUrl);
		    }
		}
	}
	

//	public void dragElement(WebElement drag){
//		  Actions action = new Actions(driver);
//		    action.moveToElement(drag, 5, 5)
//		        .clickAndHold()
//		        .moveToElement(container, 5, 5)
//		        .release()
//		        .build()
//		        .perform();
//	}
	
	
	public void dragElement(WebElement drag){
		try {
			String dragAndDropFn = new String(Files.readAllBytes(Paths.get(Data.nativeJsDragAndDropHelper)));
			((JavascriptExecutor)driver).executeScript(dragAndDropFn + "simulateDragDrop(arguments[0], arguments[1]);", drag , container);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void dragElement(WebElement drag){
//		Actions action = new Actions(driver);
//		action.moveToElement(drag).perform();
//		action.clickAndHold(drag).perform();
//		action.moveToElement(container).perform();
//		action.release(drag).perform();
//	}
	
//	public void dragElement(WebElement drag) {
//	    String xto=Integer.toString(container.getLocation().x);
//	    String yto=Integer.toString(container.getLocation().y);
//	    ((JavascriptExecutor)driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
//	    "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
//	    drag,xto,yto);
//	}
	
//	private void dragElement(WebElement drag) throws AWTException, InterruptedException{
//		Robot robot = new Robot();
//        robot.setAutoDelay(50);
//        
//        //Fullscreen page so selenium coordinates work
//        robot.keyPress(KeyEvent.VK_F11);
//        Thread.sleep(2000);
//        
//        //Get size of elements
//        Dimension fromSize = drag.getSize();
//        Dimension toSize = container.getSize();
//
//        //Get centre distance
//        int xCentreFrom = fromSize.width / 2;
//        int yCentreFrom = fromSize.height / 2;
//        int xCentreTo = toSize.width / 2;
//        int yCentreTo = toSize.height / 2;
//
//        //Get x and y of WebElement to drag to
//        Point fromLocation = drag.getLocation();
//        Point toLocation = container.getLocation();
//        
//        //Make Mouse coordinate centre of element
//        toLocation.x += xCentreTo;
//        toLocation.y += yCentreTo;
//        fromLocation.x += xCentreFrom;
//        fromLocation.y += yCentreFrom;
//
//        //Move mouse to drag from location
//        robot.mouseMove(fromLocation.x, fromLocation.y);
//
//        //Click and drag
//        robot.mousePress(InputEvent.BUTTON1_MASK);
//
//        //Drag events require more than one movement to register
//        //Just appearing at destination doesn't work so move halfway first
//        robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x, ((toLocation.y
//        				- fromLocation.y) / 2) + fromLocation.y);
//
//        //Move to final position
//        robot.mouseMove(toLocation.x, toLocation.y);
//
//        //Drop
//        robot.mouseRelease(InputEvent.BUTTON1_MASK);
//
//	}
	
	public void dragElements(){
		dragElement(draggable1);
		dragElement(draggable2);
		dragElement(draggable3);
		dragElement(draggable4);
		//dragElement(driver.findElement(By.xpath("//img[@src='http://www.seleniumeasy.com/sites/default/files/seleniumEasy_0.jpg']")));

	}
	public String getDroppedList(){
		return driver.findElement(By.xpath("//div[@id='droppedlist']")).getText();
	}
	
}
