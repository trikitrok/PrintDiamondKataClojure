# Print Diamond kata in Clojure

Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.

For example:

(print-diamond "A") will print
<pre>
  A
</pre>

(print-diamond "B") will print
<pre>
  A
 B B
  A
</pre>

(print-diamond "C") will print
<pre>
  A
 B B
C   C
 B B
  A
</pre>

and so on.

Source: [Seb Rose's blog](http://claysnow.co.uk/)

## How to run the tests

The project uses [Midje](https://github.com/marick/Midje/).

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
