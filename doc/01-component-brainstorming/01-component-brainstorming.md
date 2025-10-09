  # Portfolio Part 1: Component Brainstorming

  - **Name**: Zayed Ali<!-- TODO: fill with first and last name (e.g., Brutus Buckeye) then delete this comment -->
  - **Dot Number**: ali.1189 <!-- TODO: fill with OSU dot number (e.g., buckeye.17) then delete this comment -->
  - **Due Date**: September 19 , 1:50 PM<!-- TODO: fill with due date and time (e.g., 10/17 @ 3:10 PM EST) then delete this comment -->

  ## Assignment Overview

  The overall goal of the portfolio project is to have you design and implement
  your own OSU component. There are no limits to what you choose to design and
  implement, but your component must fit within the constraints of our software
  sequence discipline. In other words, the component must extend from Standard and
  must include both a kernel and a secondary interface.

  Because this is a daunting project, we will be providing you with a series of
  activities to aid in your design decisions. For example, the point of this
  assignment is to help you brainstorm a few possible components and get some
  feedback. For each of these components, you will need to specify the high-level
  design in terms of the software sequence discipline. In other words, you will
  describe a component, select a few kernel methods for your component, and select
  a few secondary methods to layer on top of your kernel methods.

  You are not required to specify contracts at this time. However, you are welcome
  to be as detailed as you'd like. More detail means you will be able to get more
  detailed feedback, which may help you decide which component to ultimately
  implement.

  ## Assignment Checklist

  <!-- TODO: browse the checklist then delete this comment -->

  To be sure you have completed everything on this assignment, we have littered
  this document with TODO comments. You can browse all of them in VSCode by
  opening the TODOs window from the sidebar. The icon looks like a tree and will
  likely have a large number next to it indicating the number of TODOS. You'll
  chip away at that number over the course of the semester. However, if you'd
  like to remove this number, you can disable it by removing the following
  line from the `settings.json` file:

  ```json
  "todo-tree.general.showActivityBarBadge": true,
  ```

  Which is not to be confused with the following setting that adds the counts
  to the tree diagram (you may remove this one as well):

  ```json
  "todo-tree.tree.showCountsInTree": true,
  ```

  ## Assignment Learning Objectives



  Without learning objectives, there really is no clear reason why a particular
  assessment or activity exists. Therefore, to be completely transparent, here is
  what we're hoping you will learn through this particular aspect of the portfolio
  project. Specifically, students should be able to:

  1. Integrate their areas of interest in their personal lives and/or careers with
    their knowledge of software design
  2. Determine the achievablility of a software design given time constraints
  3. Design high-level software components following the software sequence
    discipline

  ## Assignment Rubric: 10 Points



  Again, to be completely transparent, most of the portfolio project, except the
  final submission, is designed as a formative assessment. Formative assessments
  are meant to provide ongoing feedback in the learning process. Therefore,
  the rubric is designed to assess the learning objectives *directly* in a way
  that is low stakes—meaning you shouldn't have to worry about the grade. Just
  do good work.

  | Learning Objective                                                                                        | Subcategory                 | Weight | Missing                                                     | Beginning                                                                              | Developing                                                                                     | Meeting                                                                                 |
  | --------------------------------------------------------------------------------------------------------- | --------------------------- | ------ | ----------------------------------------------------------- | -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
  | Students should be able to identify their values, interests, and/or goals as they relate to their designs | Metacognitive Memory        | 3      | (0) No attempt to summarize values, interests, and/or goals | (1) A brief description of values, interests, and/or goals is provided but lacks depth | (2) A description of values, interests, and/or goals is provided by are not related to designs | (3) A description of values, interests, and/or goals is provided and relates to designs |
  | Students should be able to predict the feasibility of their designs                                       | Metacognitive Understanding | 3      | (0) No attempt to design components that are feasible       | (1) At least one component is feasible                                                 | (2) At least two components are feasible                                                       | (3) All three components are feasible                                                   |
  | Students should be able to use the OSU discipline in all three designs                                    | Metacognitive Application   | 4      | (0) No attempt to follow the OSU discipline in designs      | (1) At least one design follows the OSU discipline                                     | (3) At least two designs follow the OSU discipline                                             | (4) All three designs follow the OSU discipline                                         |

  Below is further rationale/explanation for the rubric items above:

  1. Each design must align with your personal values and long-term
    goals. Because the goal of this project is to help your build out a
    portfolio, you really ought to care about what you're designing. We'll give
    you a chance to share your personal values, interests, and long-term goals
    below.
  2. Each design must be achievable over the course of a single
    semester. Don't be afraid to design something very small. There is no shame
    in keeping it simple.
  3. Each design must fit within the software sequence discipline. In
    other words, your design should expect to inherit from Standard, and it
    should contain both kernel and secondary methods. Also, null and aliasing
    must be avoided, when possible. The methods themselves must also be in
    justifiable locations, such as kernel or secondary.

  ## Pre-Assignment

  > Before you jump in, we want you to take a moment to share your interests
  > below. Use this space to talk about your career goals as well as your personal
  > hobbies. These will help you clarify your values before you start
  > brainstorming. Plus it helps us get to know you better! Feel free to share
  > images in this section.

  I am interested in enterprenuership in the field of AI/ML. My personal hobbies
  are building projects and playing games. I am currently working on a Spring Boot
  project where I am building a store like Amazon.

  ## Assignment



  As previously stated, you are tasked with brainstorming 3 possible components.
  To aid you in this process, we have provided [some example components][example-components]
  that may help you in your brainstorming. All of these components were made at
  some point by one of your peers, so you should feel confident that you can
  accomplish any of them.



  There is no requirement that you use any of the components listed above.
  If you want to model something else, go for it! Very common early object
  projects usually attempt to model real-world systems like banks, cars,
  etc. Make of this whatever seems interesting to you, and keep in mind that
  you're just brainstorming right now. You do not have to commit to anything.

  ### Example Component



  To help you brainstorm a few components, we've provided an example below of a
  component you already know well: NaturalNumber. We highly recommend that you
  mirror the formatting as close as possible in your designs. By following this
  format, we can be more confident that your designs will be possible.

  - Example Component: `NaturalNumber`
    - **Description**:
      - The purpose of this component is to model a non-negative
        integer. Our intent with this design was to keep a simple kernel that
        provides the minimum functionality needed to represent a natural number.
        Then, we provide more complex mathematical operations in the secondary
        interface.
    - **Kernel Methods**:
      - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
      - `int divideBy10()`: divides `this` by 10 and reports the remainder
      - `boolean isZero()`: reports whether `this` is zero
    - **Secondary Methods**:
      - `void add(NaturalNumber n)`: adds `n` to `this`
      - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
      - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
      - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
        the remainder
      - ...
    - **Additional Considerations** (*note*: "I don't know" is an acceptable
      answer for each of the following questions):
      - Would this component be mutable? Answer and explain:
        - Yes, basically all OSU components have to be mutable as long as they
          inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
          mutate `this`.
      - Would this component rely on any internal classes (e.g., `Map.Pair`)?
        Answer and explain:
        - No. All methods work with integers or other NaturalNumbers.
      - Would this component need any enums or constants (e.g.,
        `Program.Instruction`)? Answer and explain:
        - Yes. NaturalNumber is base 10, and we track that in a constant called
            `RADIX`.
      - Can you implement your secondary methods using your kernel methods?
        Answer, explain, and give at least one example:
        - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
          manipulate our natural number as needed. For example, to implement
          `increment`, we can trim the last digit off with `divideBy10`, add 1 to
          it, verify that the digit hasn't overflown, and multiply the digit back.
          If the digit overflows, we reset it to zero and recursively call
          `increment`.

  Keep in mind that the general idea when putting together these layered designs
  is to put the minimal implementation in the kernel. In this case, the kernel is
  only responsible for manipulating a digit at a time in the number. The secondary
  methods use these manipulations to perform more complex operations like
  adding two numbers together.

  Also, keep in mind that we don't know the underlying implementation. It would be
  completely reasonable to create a `NaturalNumber1L` class which layers the
  kernel on top of the existing `BigInteger` class in Java. It would also be
  reasonable to implement `NaturalNumber2` on top of `String` as seen in
  Project 2. Do not worry about your implementations at this time.

  On top of everything above, there is no expectation that you have a perfect
  design. Part of the goal of this project is to have you actually use your
  component once it's implemented to do something interesting. At which point, you
  will likely refine your design to make your implementation easier to use.

  ### Component Designs

  > Please use this section to share your designs.

  - Component Design #1: Music Playlist
    - **Description**:
      - Models an ordered list of music tracks with unique IDs, supporting
      add/insert/remove, move, search/filter, and deterministic shuffle.
      Emphasizes avoiding aliasing by keeping Track immutable and maintaining
      an internal Set of IDs to prevent duplicates.
    - **Kernel Methods**:
      - void clear() – empties the playlist.
        void addToEnd(Track t) – appends track t; requires t.id not already present.
        void insertAt(int index, Track t) – inserts t at index (0..|this|); requires unique ID.
        Track removeAt(int index) – removes and returns track at index (0..|this|-1).
        int length() – number of tracks.
    - **Secondary Methods**:
      - void move(int from, int to) – moves a track using removeAt then insertAt.
        void shuffle(long seed) – Fisher–Yates style shuffle using only kernel ops (deterministic for tests).Sequence<Track> findByArtist(String artist) – returns a copy with matching tracks (no rep exposure).int indexOf(String id) – returns first index for a track ID or −1.int totalDurationSec() – sums durations (or reads a cached total kept consistent by kernel).

    - **Additional Considerations** (*note*: "I don't know" is an acceptable
      answer for each of the following questions):
      - Would this component be mutable? Answer and explain:
        - Yes as it can change over time
      - Would this component rely on any internal classes (e.g., `Map.Pair`)?
        Answer and explain:
        - Maybe because I did not understand the question
      - Would this component need any enums or constants (e.g.,
        `Program.Instruction`)? Answer and explain:
        - No
      - Can you implement your secondary methods using your kernel methods?
        Answer, explain, and give at least one example:
        - Yes as move(from, to) = insertAt(to, removeAt(from)). shuffle(seed) repeatedly uses removeAt/insertAt to     permute without exposing internals.

  - Component Design #2: Meal Planner
    - **Description**:
      - Weekly meal planner that assigns meals to days, supports add/remove/move,
       and can generate a consolidated grocery list from ingredient maps.
       Focus is on layering: minimal kernel for day-scoped add/remove/read;
      secondary methods aggregate and reorganize.
    - **Kernel Methods**:
      - void clear() – clears all days.
        void addMeal(Day d, Meal m) – appends m to day d.
        Meal removeMealAt(Day d, int index) – removes and returns the meal at
        index for day d.
        int length(Day d) – number of meals on day d.
        Sequence<Meal> mealsOn(Day d) – returns a copy of meals for day d.

    - **Secondary Methods**:
    - Map<String, NaturalNumber> groceryList() – aggregates ingredient quantities across all days.
      void moveMeal(Day from, int i, Day to, int j) – moves a meal using kernel remove/insert.
      Sequence<Meal> findByTag(String tag) – returns meals across all days with a given tag.
      NaturalNumber weeklyCalories() – sum of calories across all meals (if modeled).
      void swapDays(Day a, Day b) – swaps two days’ plans.

    - **Additional Considerations** (*note*: "I don't know" is an acceptable
      answer for each of the following questions):
      - Would this component be mutable? Answer and explain:
        - Yes as plans change almost every time.
      - Would this component rely on any internal classes (e.g., `Map.Pair`)?
        Answer and explain:
        - Idk yet
      - Would this component need any enums or constants (e.g.,
        `Program.Instruction`)? Answer and explain:
        - No
      - Can you implement your secondary methods using your kernel methods?
        Answer, explain, and give at least one example:
        - Yes as groceryList() iterates mealsOn(d) for each day, folds
         ingredient maps into a new map (no rep exposure) using NaturalNumber arithmetic.

  - Component Design #3: Shopping Cart
    - **Description**:
      - E-commerce shopping cart with unique item IDs and quantities, supporting add/update/remove lines and computing totals. Secondary methods implement promotions (percent coupons, BOGO) and sorted views without exposing representation.
    - **Kernel Methods**:
      - void clear() – empties the cart.
        void addItem(Item it, NaturalNumber qty) – adds a line; requires qty > 0 and it.id not present.
        void updateQuantity(String id, NaturalNumber qty) – sets quantity; qty = 0 removes line.
        Item getItem(String id) – returns the immutable item metadata (or a copy).
        NaturalNumber getQuantity(String id) – returns quantity or 0 if absent.
        int size() – distinct line count.

    - **Secondary Methods**:
      - NaturalNumber subtotalCents() – Σ(unitPriceCents × qty).
        NaturalNumber applyPercentCoupon(int pct) – returns discounted total (define rounding/floor).
        NaturalNumber totalAfterBOGO(String id) – recomputes total where that item is buy-one-get-one.
        Sequence<Item> itemsSortedByPrice() – returns a copy of items sorted by price ascending.
        boolean contains(String query) – substring match on item name/tags (define case sensitivity).
    - **Additional Considerations** (*note*: "I don't know" is an acceptable
      answer for each of the following questions):
      - Would this component be mutable? Answer and explain:
      - Idk
      - Would this component rely on any internal classes (e.g., `Map.Pair`)?
        Answer and explain:
        - Idk
      - Would this component need any enums or constants (e.g.,
        `Program.Instruction`)? Answer and explain:
        - Idk
      - Can you implement your secondary methods using your kernel methods?
        Answer, explain, and give at least one example:
        - Idk

  ## Post-Assignment

  The following sections detail everything that you should do once you've
  completed the assignment.

  ### Peer Review

  <!-- TODO: review the peer review guidelines then delete this comment -->

  Following the completion of this assignment, you will be assigned three
  students' component brainstorming assignments for review. Your job during the
  peer review process is to help your peers flesh out their designs. Specifically,
  you should be helping them determine which of their designs would be most
  practical to complete this semester. When reviewing your peers' assignments,
  please treat them with respect. Note also that we can see your comments, which
  could help your case if you're looking to become a grader. Ultimately, we
  recommend using the following feedback rubric to ensure that your feedback is
  both helpful and respectful (you may want to render the markdown as HTML or a
  PDF to read this rubric as a table).

  | Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
  | --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
  | Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
  | Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
  | Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
  | Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
  | Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

  ### Assignment Feedback

  If you'd like to give feedback for this assignment (or any assignment, really),
  make use of [this survey][survey]. Your feedback helps make assignments
  better for future students.

  <!-- TODO: follow the link to share your feedback then delete this comment -->

  [example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
  [markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
  [survey]: https://forms.gle/dumXHo6A4Enucdkq9
