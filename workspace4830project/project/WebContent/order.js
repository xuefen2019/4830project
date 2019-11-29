new Vue({
    el: '#app',
    data: {
        currentFilter: 'ALL',
        projects: [
            {title: "Beef with broccoli", image: "Food/Beef.jpg", category: 'Beef', counter: 0, calories: 398, nutrition:
                    "Beef-with-broccoli\n1 pound sirloin steak\n2 tablespoons cornstarch (divided)\n1/4 teaspoon salt\n" +
                    "1 tablespoon sesame oil\n2 garlic cloves (minced)\n1/2 cup water\n4 cups broccoli florets (chopped)\n" +
                    "1/2 cup vegetable broth\n1/4 cup soy sauce\nOptional: 1 tablespoon toasted sesame seeds\nCalories: 398"},
            {title: "Pork with bell pepper", image: "Food/Bellepork.jpg", category: 'Pork', counter: 0, calories: 352, nutrition:
                    "Pork-with-bell-pepper\n150g boneless pork chops, cut into strips (raw)\n1/16 teaspoon thyme\n" +
                    "1/16 teaspoon garlic powder\n1 tablespoon packed brown sugar\n1 tablespoon Ketchup\n3/4 teaspoon Worcestershire sauce\n" +
                    "3/4 teaspoon soy sauce\n50g green pepper, cut into matchsticks\n80g mushrooms, sliced\n40g onion, diced\nCalories: 352.2"},
            {title: "Eggs drop soup", image: "Food/Eggs.jpg", category: 'Appetizer', counter: 0, calories: 112, nutrition:
                    "Egg drop soup\n4 cups low-sodium chicken broth\n1 tablespoon reduced-sodium soy sauce\n1/4 teaspoon ground ginger\n" +
                    "2 tablespoons cornstarch\n2 tablespoons water\n2 large eggs, beaten\n1/4 teaspoon kosher salt\n(optional) 1/4 teaspoon sesame oil\n" +
                    "1/4 cup sliced green onions\nCalories: 112"},
            {title: "Fried chicken wings", image: "Food/Fried.png", category: 'Appetizer', counter: 0, calories: 308, nutrition:
                    "Fried the chicken wings\n2 pounds chicken wings or drumsticks\n1/4 teaspoon kosher salt\n1/4 teaspoon freshly ground black pepper\n" +
                    "1/4 cup hot sauce (such as Frank's Red Hot)\n1 tablespoons olive oil\n1 tablespoon cornstarch\n1/2 lemon, juiced\nCalories: 308"},
            {title: "Mongolian Beef", image: "Food/Mogo.jpg", category: 'Beef', counter: 0, calories: 231, nutrition:
                    "Mongolian beef\nMongolian sauce\n1 pound sirloin steak\n2 tablespoons cornstarch (divided)\n1/4 teaspoon salt\n" +
                    "1 tablespoon sesame oil\n2 garlic cloves (minced)\n1/2 cup water\n4 cups broccoli florets (chopped)\n1/2 cup vegetable broth\n" +
                    "1/4 cup soy sauce\nOptional: 1 tablespoon toasted sesame seeds\n\n2 tbsp. low sodium soy sauce\n" +
                    "1 tsp. sugar (leave out for low carb/Clean eating)\n1 tsp. cornstarch\n1 tbsp. rice vinegar\n1 tbsp. hoisin sauce\n" +
                    "2 tsp. Asian garlic chili paste (like sambal oelek)\n2 tsp. vegetable oil\n1 tbsp. ginger, minced\n1 garlic clove, minced\n" +
                    "1 lb. lean sirloin beef, thinly sliced across the grain\n8 green onions, chopped\nCalories:231"},
            {title: "Vegetable Salad", image: "Food/Salad.jpg", category: 'Appetizer', counter: 0, calories: 38, nutrition:
                    "Vegetable salad\n4 cups mixed salad greens\n2 oz low-fat cheddar cheese\n1/2 cup cucumber slices\n" +
                    "1/2 cup tomato, diced\n1/2 cup sliced red bell pepper\n1/4 cup avocado, diced\n1 cup garbanzo beans\n" +
                    "1/2 cup crimini mushrooms\n3 TBS sunflower seeds\nCalories: 38.8"},
            {title: "Hot Sour Soup", image: "Food/hot_soup.jpg", category: 'Appetizer', counter: 0, calories: 93, nutrition:
                    "Hot and sour soup\n3 tablespoons rice vinegar\n2 tablespoons cornstarch\n6 cups reduced sodium chicken broth\n" +
                    "2 tablespoons reduced sodium soy sauce\n3 cloves garlic, minced\n1 tablespoon freshly grated ginger\n" +
                    "1 teaspoon Sriracha, optional\n6 ounces shiitake mushrooms, thinly sliced\n2 large eggs, lightly beaten\n" +
                    "6 ounces extra-firm tofu, drained and thinly sliced\n1 teaspoon sesame oil\n2 green onions, thinly sliced\nCalories:93.7"},
            {title: "Moo-shu Pork", image: "Food/Muxu.jpg", category: 'Pork', counter: 0, calories: 210, nutrition:
                    "Moo-Shu-pork\n1 1/2 tbsp. reduced-sodium/lite soy sauce\n1 1/2 tbsp. rice vinegar\n2 tsp. granulated white sugar\n" +
                    "1/2 tsp. crushed garlic\n1/2 tsp. chopped ginger\n1/4 tsp. cornstarch\n" +
                    "One 6-oz. raw boneless pork tenderloin, trimmed of excess fat, cut in half lengthwise, thinly sliced\n" +
                    "Dash each salt and black pepper\n2 cups bagged cole slaw mix\n1 cup thinly sliced shiitake mushroom caps\n" +
                    "1 cup bean sprouts\n1/2 cup canned bamboo shoots, drained\n1/4 cup thinly sliced scallions\n1 1/2 tbsp. hoisin sauce\n" +
                    "1 tsp. sesame oil\n8 six-inch high-fiber flour tortillas with about 50 calories each\nCalories: 210"},
            {title: "Orange Chicken", image: "Food/Orange.jpg", category: 'Chicken', counter: 0, calories: 420, nutrition:
                    "Orange-chicken\nOrange Sauce\n1/2 cup orange juice, (120ml)\n1 teaspoon orange zest, (1g) optional\n" +
                    "1/3 cup unsalted chicken broth, (79ml)\n2 tablespoons soy sauce , (30ml)\n3 tablespoons honey, (45ml)\n" +
                    "2 teaspoons rice vinegar, (10ml) or lemon juice\n1/8 teaspoon red chili flakes, (add more if you like it spicy)\n" +
                    "2 teaspoons cornstarch, (6g)\n4 teaspoons water, (20ml)\nChicken\n1 1/2 pounds boneless skinless chicken breast, (681g) cut into 1-inch cubes\n" +
                    "1 teaspoon kosher salt, (2g)\n1/2 teaspoon black pepper, freshly ground\n1/2 teaspoon sesame oil, (2.5ml)\n2 tablespoons vegetable oil, (30ml)\n" +
                    "1 tablespoons minced garlic, (10g)\n1 tablespoons minced ginger, (8g)\n1 tablespoon sliced green onions, (1g)\n1/2 teaspoon sesame seeds\nCalories: 420"},
            {title: "Seasame Chicken", image: "Food/Seasame.jpg", category: 'Chicken', counter: 0, calories: 270, nutrition:
                    "Sesame-chicken\n1 pound boneless skinless chicken breasts (cut into 1/2 inch strips or cubes)\n2 Tablespoons cornstarch\n" +
                    "1 pinch each salt & pepper\n1 tablespoon olive oil or sesame\nCooked white rice for serving\nSmall bunch spring onions scallions, chopped\n" +
                    "For the sauce\n3 Tablespoons soy sauce\n2 tablespoons honey\n1 teaspoon sriracha add more for more heat\n1 teaspoon fresh ginger grated\n" +
                    "1 clove garlic minced\n2 Tablespoons sesame seeds\n1 tablespoon sesame oil optional\nCalories:270"},
            {title: "Spring rolls", image: "Food/Springroll.jpg", category: 'Appetizer', counter: 0, calories: 148, nutrition:
                    "Spring roll\nFilling\n1 cup sliced bamboo shoots (about 4 ounces, see note 1)\n2 tablespoons peanut oil, divided (note 2)\n" +
                    "6 ounces ground pork\n1/3 cup diced shallots (about 1/2 of a large shallot)\n1 3/4 cups shredded carrots (about 5 ounces)\n" +
                    "3 cups chopped green cabbage (about 7.5 ounces)\n1/2 cup diced water chestnuts (about 3 to 4 water chestnuts, see note 3)\n" +
                    "1 tablespoon cornstarch\n2 tablespoons water\n1 tablespoon oyster sauce\n1 teaspoon salt\n1 teaspoon sugar\n" +
                    "1/2 teaspoon ground white pepper\nSpring Rolls\n15 to 20 8-inch spring roll wrappers (note 4)\n1 egg, lightly beaten\n" +
                    "oil for frying\ncalories:148"},
        ],
    },
    methods: {
        setFilter: function(filter) {
            this.currentFilter = filter;
        },
        nutrition: function(idx)
        {
            swal(this.projects[idx].nutrition);
        },
        increase: function(idx)
        {
            if (this.projects[idx].counter > 9)
                swal("We know you like "+this.projects[idx].title+"\nbut please leave some food for other customers!");
            else
                this.projects[idx].counter++;
        },
        decrease: function(idx)
        {
            if (this.projects[idx].counter == 0)
                swal("If you don't like "+this.projects[idx].title+", look at other foods!");
            else
                this.projects[idx].counter--;
        },
        result: function()
        {
        	var input = document.getElementById("submit");
        	input.value = this.projects[0].counter+","+this.projects[1].counter+","+this.projects[2].counter+","+this.projects[3].counter+","+this.projects[4].counter+","+this.projects[5].counter+","+this.projects[6].counter+","+this.projects[7].counter+","+this.projects[8].counter+","+this.projects[9].counter+","+this.projects[10].counter;
        }
    }
})
