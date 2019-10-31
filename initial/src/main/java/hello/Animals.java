package hello;

class Animal {

    /*
     * Boolean indicating whether this animal has recently fed.
     */
    private boolean fed = false;
  
    /*
     * Name of this animal.
     */
    protected final String name;
  
    Animal (String name) {
      this.name = name;
    }

    void feed () {
      this.fed = true;
    }
  
    boolean isFed () {
      return this.fed;
    }
  
  }