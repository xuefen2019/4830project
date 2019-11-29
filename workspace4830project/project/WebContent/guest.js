new Vue({

    el: '#app',
    data: {
        currentFilter: 'ALL',
        projects: [
            {title: "Beef with broccoli", image: "Food/Beef.jpg", size: {width:600, height:400}, category: 'Beef'},
            {title: "Pork with bell pepper", image: "Food/Bellepork.jpg", size: {width:600, height:400} ,category: 'Pork'},
            {title: "Eggs drop soup", image: "Food/Eggs.jpg", size: {width:600, height:400} ,category: 'Appetizer'},
            {title: "Fried chicken wings", image: "Food/Fried.png", size: {width:600, height:400} ,category: 'Appetizer'},
            {title: "Mongolian Beef", image: "Food/Mogo.jpg", size: {width:600, height:400} ,category: 'Beef'},
            {title: "Vegetable Salad", image: "Food/Salad.jpg", size: {width:600, height:400}, category: 'Appetizer'},
            {title: "Hot Sour Soup", image: "Food/hot_soup.jpg", size: {width:600, height:400}, category: 'Appetizer'},
            {title: "Moo-shu Pork", image: "Food/Muxu.jpg", size: {width:600, height:400}, category: 'Pork'},
            {title: "Orange Chicken", image: "Food/Orange.jpg", size: {width:600, height:400}, category: 'Chicken'},
            {title: "Seasame Chicken", image: "Food/Seasame.jpg", size: {width:600, height:400}, category: 'Chicken'},
            {title: "Spring rolls", image: "Food/Springroll.jpg", size: {width:600, height:400}, category: 'Appetizer'},
        ]
    },
    methods: {
        setFilter: function(filter) {
            this.currentFilter = filter;
        }
    }
})