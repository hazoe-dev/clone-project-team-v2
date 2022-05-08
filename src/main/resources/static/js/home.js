$("#list-suggest").owlCarousel({
  loop: true,
  margin: 10,
  nav: true,
  dots: false,
  navContainer: ".list-product-container .header-list #owl-nav-1",
  //navText: [$('#am-next'),$('#am-prev')],
  responsive: {
    0: {
      items: 1,
    },
    600: {
      items: 2,
    },
    1000: {
      items: 4,
    },
  },
});

$("#list-new").owlCarousel({
  loop: true,
  margin: 10,
  nav: true,
  dots: false,
  navContainer: ".list-product-container .header-list #owl-nav-2",
  //navText: [$('#am-next'),$('#am-prev')],
  responsive: {
    0: {
      items: 1,
    },
    600: {
      items: 2,
    },
    1000: {
      items: 4,
    },
  },
});

$("#list-story").owlCarousel({
  loop: true,
  margin: 10,
  nav: true,
  dots: false,
  navContainer: ".list-product-container .header-list #owl-nav-3",
  //navText: [$('#am-next'),$('#am-prev')],
  responsive: {
    0: {
      items: 1,
    },
    600: {
      items: 2,
    },
    1000: {
      items: 4,
    },
  },
});
