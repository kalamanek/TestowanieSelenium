package testy.testSiuts;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testy.testCases.testAjaxFormSubmitDemo.TestAjaxFormSubmitDemo;
import testy.testCases.testBasicFirstFromDemo.TestBasicFirstFromDemo;
import testy.testCases.testBasicRadiobuttonDemo.TestBasicRadiobuttonDemo;
import testy.testCases.testBootstrapAltertMessages.TestBootstrapAltertMessages;
import testy.testCases.testBootstrapModalDemo.TestBootstrapModalDemo;
import testy.testCases.testBootstrapProgressBarDialogDemo.TestBootstrapProgressBarDialogDemo;
import testy.testCases.testCheckboxDemo.TestCheckboxDemo;
import testy.testCases.testDragAndDropDemo.TestDragAndDropDemo;
import testy.testCases.testDynamicDataLoadingDemo.TestDynamicDataLoadingDemo;
import testy.testCases.testTablePaginationDemo.TestTablePaginationDemo;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestAjaxFormSubmitDemo.class,
    TestBasicFirstFromDemo.class,
    TestBasicRadiobuttonDemo.class,
    TestBootstrapAltertMessages.class,
    TestBootstrapModalDemo.class,
    TestBootstrapProgressBarDialogDemo.class,
    TestCheckboxDemo.class,
    TestDragAndDropDemo.class,
    TestDynamicDataLoadingDemo.class,
    TestTablePaginationDemo.class
})
public class SampleSuitTests{
}