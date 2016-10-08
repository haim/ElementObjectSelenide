package gsmserver.Utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CustomConditions {

    public static Condition classError() {
        return Condition.cssClass("error");
    }

    public static Condition cannotBeBlankTitleTip() {
        return Condition.attribute("title", "This field cannot be blank");
    }

    public static Condition originalTitleTip(final String text) {
        return Condition.attribute("title", text);
    }

    private static Condition labelRequired(){
        return Condition.and("have '*'", Condition.text("*"), attributeRequired());
    }
    private static Condition attributeRequired(){
        return Condition.or("class 'required' or data-validator='required'", Condition.cssClass("required"), Condition.attribute("data-validator","required"));
    }

    public static void signaturesOfFieldsHaveRequiredLabel(SelenideElement... elements){
        for(SelenideElement element : elements) {
            element.parent().has(labelRequired());
        }
    }
    public static void signaturesOfFieldsHaveNoRequiredLabel(SelenideElement... elements){
        for(SelenideElement element : elements) {
            element.parent().shouldNotHave(labelRequired());
        }
    }

}