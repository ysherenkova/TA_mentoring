package ua.mentoring.addressbook.tests;// Generated by Selenium IDE

import org.testng.annotations.Test;

import ua.mentoring.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().gotoGroupPage();
    applicationManager.getGroupHelper().createGroup(new GroupData("NewGroup", "", ""));

 //   applicationManager.getGroupHelper().initGroupCreation();
 //   applicationManager.getGroupHelper().fillGroupForm(new GroupData("NewGroup", "", ""));
 //   applicationManager.getGroupHelper().submitGroupCreation();
 //   applicationManager.getGroupHelper().returnToGroupPage();

  }

}
