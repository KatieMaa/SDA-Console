package pl.sdacademy.model;

/**
 * Created by RENT on 2017-03-15.
 */


    public enum StreetPrefix {

        STREET("ul."), AVENUE("al."), SQUARE("pl."),;

        private final String prefix;

        StreetPrefix (String prefix){
            this.prefix = prefix;
        }

    public String getPrefix() {
        return prefix;
    }
}

