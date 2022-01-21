package writeo;

import java.util.List;

public class Children {
    private java.util.List<data.ChildInputData> children;

    /**
     *
     * @return ...
     */
    public java.util.List<data.ChildInputData> getChildren() {
        return children;
    }

    public Children() {
    }

    public Children(final java.util.List<data.ChildInputData> children) {
        this.children = new java.util.ArrayList<>();
        for (data.ChildInputData child:children) {
            if (child.getAge() <= common.Constants.EIGHTEEN) {
                this.children.add(new data.ChildInputData(child));
            }
        }
    }

    /**
     *
     * @param annualChildren ...
     */
    public void setChildren(final java.util.List<data.ChildInputData> annualChildren) {
        this.children = annualChildren;
    }
}
