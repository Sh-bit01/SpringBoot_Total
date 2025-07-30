package org.core;

import java.util.*;
import java.util.stream.*;


public class App
{
    public static void main( String[] args )
    {
        StreamApi st = new StreamApi();

        st.filter();
        st.collect();
        st.count();
        st.forEach();
        st.limited();
        st.reduce();
        st.sorted();
        st.upperCase();

    }
}
