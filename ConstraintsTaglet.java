import com.sun.tools.doclets.Taglet;
import com.sun.javadoc.*;
import java.util.Map;

/**
 * A Taglet representing @constraint. This tag can be used in any kind of
 * {@link com.sun.javadoc.Doc}.  It is not an inline tag. The text is displayed
 * in like @param or @returns.
 *
 * @author Terin Stock
 * @version 10.13.09
 * @license GNU LGPL
 */

public class ConstraintsTaglet implements Taglet {
    
    private static final String NAME = "constraint";
    private static final String HEADER = "Constraints:";
    
    /**
     * Returns the name of this custom tag.
     * @return the name of this custom tag.
     */
    public String getName() {
        return NAME;
    }
    
    /**
     * Will return true since <code>@constraint</code>
     * can be used in field documentation.
     * @return true since <code>@constraint</code>
     * can be used in field documentation and false
     * otherwise.
     */
    public boolean inField() {
        return true;
    }

    /**
     * Will return true since <code>@constraint</code>
     * can be used in constructor documentation.
     * @return true since <code>@constraint</code>
     * can be used in constructor documentation and false
     * otherwise.
     */
    public boolean inConstructor() {
        return true;
    }
    
    /**
     * Will return true since <code>@constraint</code>
     * can be used in method documentation.
     * @return true since <code>@constraint</code>
     * can be used in method documentation and false
     * otherwise.
     */
    public boolean inMethod() {
        return true;
    }
    
    /**
     * Will return true since <code>@constraint</code>
     * can be used in method documentation.
     * @return true since <code>@constraint</code>
     * can be used in overview documentation and false
     * otherwise.
     */
    public boolean inOverview() {
        return true;
    }

    /**
     * Will return true since <code>@constraint</code>
     * can be used in package documentation.
     * @return true since <code>@constraint</code>
     * can be used in package documentation and false
     * otherwise.
     */
    public boolean inPackage() {
        return true;
    }

    /**
     * Will return true since <code>@constraint</code>
     * can be used in type documentation (classes or interfaces).
     * @return true since <code>@constraint</code>
     * can be used in type documentation and false
     * otherwise.
     */
    public boolean inType() {
        return true;
    }
    
    /**
     * Will return false since <code>@constraint</code>
     * is not an inline tag.
     * @return false since <code>@constraint</code>
     * is not an inline tag.
     */
    
    public boolean isInlineTag() {
        return false;
    }
    
    /**
     * Register this Taglet.
     * @param tagletMap  the map to register this tag to.
     */
    public static void register(Map tagletMap) {
       ConstraintsTaglet tag = new ConstraintsTaglet();
       Taglet t = (Taglet) tagletMap.get(tag.getName());
       if (t != null) {
           tagletMap.remove(tag.getName());
       }
       tagletMap.put(tag.getName(), tag);
    }

    /**
     * Given the <code>Tag</code> representation of this custom
     * tag, return its string representation.
     * @param tag   the <code>Tag</code> representation of this custom tag.
     */
    public String toString(Tag tag) {
        return "<DT><B>" + HEADER + "</B><DD>"
               + tag.text()
               + "\n";
    }
    
    /**
     * Given an array of <code>Tag</code>s representing this custom
     * tag, return its string representation.
     * @param tags  the array of <code>Tag</code>s representing of this custom tag.
     */
    public String toString(Tag[] tags) {
        if (tags.length == 0) {
            return null;
        }
        String result = "\n<DT><B>" + HEADER + "</B><DD>";
        for (int i = 0; i < tags.length; i++) {
            if (i > 0) {
                result += "<DD>";
            }
            result += tags[i].text();
        }
        return result + "\n";
    }
}
