/* ----------------------------------------------*/
/*  For Chart Section 2
/*-----------------------------------------------*/
if (jQuery('#chart-legend-pointstyle').length > 0) {
    var ctx = document.getElementById('chart-legend-pointstyle').getContext('2d');
    var chartW = jQuery('#chart-legend-pointstyle').width();
    var my_gradient = ctx.createLinearGradient(0, 0, chartW, 0);
    my_gradient.addColorStop(0, "#efefef");
    my_gradient.addColorStop(0.1667, "#f3f3f3");
    my_gradient.addColorStop(0.1667, "#ececec");
    my_gradient.addColorStop(0.3334, "#f3f3f3");
    my_gradient.addColorStop(0.3334, "#ececec");
    my_gradient.addColorStop(0.5001, "#f3f3f3");
    my_gradient.addColorStop(0.5001, "#ececec");
    my_gradient.addColorStop(0.6667, "#f3f3f3");
    my_gradient.addColorStop(0.6667, "#ececec");
    my_gradient.addColorStop(0.8334, "#f3f3f3");
    my_gradient.addColorStop(0.8334, "#ececec");
    my_gradient.addColorStop(1, "#f3f3f3");

    var chart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [{
                label: "My First dataset",
                data: [0, 0, 0, 0, 0, 0, 0],
                backgroundColor: my_gradient,
                borderColor: 'rgba(255, 255, 255, 0)',
                borderWidth: 0,
                pointStyle: 'circle',
                pointRadius: 5,
                pointBorderColor: 'rgb(0, 80, 239)',
                pointBackgroundColor: 'rgb(255, 255, 255)',
                steppedLine: false,
                lineTension: 0
                    }]
        },
        options: {
            responsive: true,
            legend: {
                display: false,
                labels: {
                    usePointStyle: false
                }
            },
            tooltips: {
                display: false
            },
            scales: {
                xAxes: [{
                    display: false,
                    scaleLabel: {
                        display: true,
                        labelString: 'Month'
                    }
                        }],
                yAxes: [{
                    display: false,
                    ticks: {
                        beginAtZero: true,
                        max: 100
                    },
                    scaleLabel: {
                        display: true,
                        labelString: 'Value'
                    }
                        }]
            },
            title: {
                display: false,
                text: 'Normal Legend'
            }
        }

    });
}

var owl = jQuery('.owl-carousel');

// Show cookie message function
  function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }
  
  function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

  function showCookie() {
    var cpolicy = getCookie("cookie-policy");
    if (cpolicy == "1") {
      return false;
    } else {
      cpolicy = "1";
      setCookie("cookie-policy", cpolicy, 30);
      return true;
    }
  }
  


// Captcha validation code  - Aman
jQuery(document).ready(function () {

    jQuery('.cookie-bar .covid .btn').click(function () {
        jQuery('.cookie-bar .covid').fadeOut();
      });
    
    
    if (showCookie()) {
      jQuery('.cookie-bar .cook').css('display', 'block').css('opacity', '1');
    }
  
    jQuery('.cookie-bar .cook button.btn').click(function () {
      jQuery('.cookie-bar .cook').fadeOut();
    });
    jQuery("input[checked='checked']").parent("section").addClass("SectionNotRequire");

    jQuery(".SectionNotRequire").hide();

    jQuery("input[checked='checked']").parent("a").addClass("aNotRequire");

    jQuery(".aNotRequire").hide();

    /* Top Search */
    jQuery('.topSearch a.btn-floating').on('click', function () {
        if (!jQuery('header .nav').hasClass('active')) {
            jQuery('header .nav').addClass('active');
            jQuery('#search').focus();
        }
    });
    jQuery('#search').on('blur', function () {
        jQuery(this).val('');
        jQuery('header .nav').removeClass('active');
    });


    /*Horizontal Sec Slider*/

    jQuery('.horizontalSecSlider > li').on('click', function () {
        var childs = jQuery('.horizontalSecSlider > li');
        var $this = jQuery(this);
        var NextIndex = jQuery(this).index();
        if (jQuery(window).width() > 991) {
            if ($this.hasClass('closed')) {
                childs.removeClass('prev next').addClass('closed');
                $this.removeClass('closed');
                childs.each(function (i, val) {
                    if (i < NextIndex) {
                        jQuery(val).addClass('prev');
                    } else if (i > NextIndex) {
                        jQuery(val).addClass('next');
                    }

                });
            }
        }
    });
		
		jQuery('.input-field').each(function() {
		if (!jQuery(this).hasClass('inputfile')) {
			jQuery(this).find('label').appendTo(jQuery(this).find('span.wpcf7-form-control-wrap'));
		}
	});
		

    if (jQuery(window).width() < 991) {
        jQuery(".contentBox .accordionTitle").click(function () {
            if (jQuery(this).hasClass('activeTab')) {
                jQuery(this).next('.innerContentBox').slideUp("slow");
                jQuery('.horizontalSecSlider li').removeClass('openTab');
                jQuery('.contentBox .accordionTitle').removeClass('activeTab');
            } else {
                jQuery(this).next('.innerContentBox').slideDown("slow");
                jQuery('.horizontalSecSlider li').removeClass('openTab');
                jQuery('.contentBox .accordionTitle').removeClass('activeTab');
                jQuery(this).addClass('activeTab');
                jQuery(this).parent().parent('li').addClass('openTab');
                jQuery(this).parents('li').siblings().find('.innerContentBox').slideUp("slow");
            }
        });
    }

    /*Horizontal Sec Slider ends*/

    /** home page banner slider **/
    if (jQuery(".homeBanner").length > 0) {
        owl.owlCarousel({
            autoplay: true,
            autoplayTimeout: 5000,
            autoplaySpeed: 700,
            loop: true,
            nav: true,
            items: 1,
            navText: ["", ""],
            onTranslated: updateIndex
        });

        var totalSlide = jQuery(".homeBanner .owl-dots .owl-dot").length;
        var currentSlide = jQuery(".homeBanner .owl-dots .owl-dot.active").index() + 1;
        jQuery(".homeBanner .owl-nav").append("<span></span>");
        jQuery(".homeBanner .owl-nav span").text(currentSlide + "/" + totalSlide);


        function updateIndex() {
            currentSlide = jQuery(".homeBanner .owl-dots .owl-dot.active").index() + 1;
            jQuery(".homeBanner .owl-nav span").text(currentSlide + "/" + totalSlide);
        }
    }




    /** full page js **/

    if (jQuery('#fullPageSection').length > 0) {
        //console.log('Ready');
        //console.log(jQuery(window).height());

        jQuery('#fullPageSection').fullpage({
            //anchors: ['pageSectionFirst', 'pageSectionSecond', 'pageSectionThird', 'pageSectionForth', 'pageSectionFifth', 'pageSectionSixth'],
            //lockAnchors: true,
            licenseKey:'03DA414C-B3624571-B030ABF5-A12965C7',
            autoScrolling: true,
            fitToSection: false,
            scrollBar: true,
            scrollingSpeed: 1000,
            normalScrollElements: '.normalScroll',
            sectionSelector: '.pageSection',
            responsiveWidth: 1367,
            bigSectionsDestination: 'top',
            afterLoad: function (anchorLink, index) {
                var index= index.index;
                if (index == 1 && jQuery('#chart-legend-pointstyle').length > 0) {
                    animateChart();
                }
                if (index == 5) {
                    setTimeout(function () {
                        jQuery('.secThree .circleBox .circleBox5').addClass('active');
                    }, 1200);
                }
                if (index == 6) {
                    setTimeout(function () {
                        jQuery('.secFourRight .hdaBottomMid .circleBox .circleBox1,.secFourRight .hdaBottomMid .circleBox .circleBox2,.secFourRight .hdaBottomMid .circleBox .circleBox3,.secFourRight .hdaBottomMid .circleBox .circleBox4,.secFourRight .hdaBottomMid .circleBox .circleBox5').addClass('active');
                    }, 2000);
                }
            },
            onLeave: function (index, nextIndex, direction) {}
        });

    }

    function animateChart() {

        var animateData = [34, 47, 50, 57, 64, 70, 85];
        var animateDataLength = animateData.length;
        var animatePoint = 0;

        var animateTimer = setInterval(function () {
            if (animatePoint < animateDataLength) {
                chart.data.datasets[0].data[animatePoint] = animateData[animatePoint];
                var updateTime = 5000 / (animatePoint + 1);
                chart.update(updateTime, true);
                animatePoint++;
            } else {
                clearInterval(animateTimer);
            }

        }, 150);

    }




    /* Home tab Functionality */

    if (jQuery(".secThreeTabList ul li").length > 0) {
        jQuery(".secThreeTabList ul").append("<span class='bulletButton'></span>");
        jQuery(".secThreeTabList ul").append("<span class='lineButtonVer'></span>");
		jQuery(".secThreeTabList a").click(function (e) {
            e.preventDefault();

            jQuery(this).parent().addClass("active");
            jQuery(this).parent().removeClass("visitedList");
            jQuery(this).parent().prevAll().addClass("visitedList");
            jQuery(this).parent().nextAll().removeClass("visitedList");
            jQuery(this).parent().siblings().removeClass("active");
            var currentTab = jQuery(this).attr("href");
            jQuery(".tabContent").not(currentTab).slideUp();
            jQuery(currentTab).slideDown();
            bulletPoint();
        });

    }

    function bulletPoint() {
        var listHeight = jQuery(".secThreeTabList ul li.active").height();
        var listPos = jQuery(".secThreeTabList ul li.active").position().top;
        jQuery(".bulletButton").css({
            'top': listPos
        });
        jQuery(".lineButtonVer").css({
            'height': listPos + listHeight
        });
    }

    function tabTrigger() {
        var totalList = jQuery(".secThreeTabList ul li").length;
        var currentList = jQuery(".secThreeTabList ul li.active");
        var currentListIndex = currentList.index();
        if (totalList > currentListIndex + 1) {
            currentList.next().children().trigger("click");
        } else {
            jQuery(".secThreeTabList ul li:first-child a").trigger("click");
        }
    }

    /** Home second tab section **/

    /* horizontal List tab Functionality */
    if (jQuery(".horizontalList ul li").length > 0) {
        jQuery(".horizontalList ul").append("<span class='bulletButtonHor'></span>");
        jQuery(".horizontalList ul").append("<span class='lineButtonHor'></span>");

        jQuery(".horizontalList a").click(function (e) {
            e.preventDefault();

            jQuery(this).parent().addClass("active");
            jQuery(this).parent().removeClass("visitedList");
            jQuery(this).parent().prevAll().addClass("visitedList");
            jQuery(this).parent().nextAll().removeClass("visitedList");
            jQuery(this).parent().siblings().removeClass("active");
            var currentTab = $(this).attr("href");
            jQuery(".hortabContent").not(currentTab).slideUp();
            jQuery(currentTab).slideDown();
            bulletPointHor();
        });

        bulletPointHor();

    }

    function bulletPointHor() {
        var listWidth = jQuery(".horizontalList ul li.active").width();
        var listindex = jQuery(".horizontalList ul li.active").index();
        var listPos = jQuery(".horizontalList ul li.active").position().left;
        var windowW = jQuery(window).width();
        var adjustment = 6 + (1980 / windowW);
        jQuery(".bulletButtonHor").css({
            'left': (listWidth / 2) + listPos + (4 * listindex)
        });
        jQuery(".lineButtonHor").css({
            'width': (listWidth / 2) + listPos + (4 * listindex)
        });

    }

    function tabTrigger1() {
        var totalList = jQuery(".horizontalList ul li").length;
        var currentList = jQuery(".horizontalList ul li.active");
        var currentListIndex = currentList.index();
        if (totalList > currentListIndex + 1) {
            currentList.next().children().trigger("click");
        } else {
            jQuery(".horizontalList ul li:first-child a").trigger("click");
        }
    }
    /* horizontal List tab Functionality */


    if (jQuery(".homeDtsTabList ul li").length > 0) {

        jQuery('ul.tabs').tabs({
            swipeable: true

        });
    }

    /** navigation js **/

    jQuery(".navToggle").click(function () {
        if (jQuery('.navigation').attr('class') === 'navigation') {
            jQuery(".navigation").addClass('navOpen');
        } else {
            jQuery(".navigation").removeClass('navOpen');
        }

    });

    /**** On Click Body Close Menu ****/
    jQuery(document).click(function () {
        if (jQuery('.navigation').hasClass('navOpen')) {
            jQuery('.navigation').removeClass("navOpen");
        }
    });


    jQuery('.navToggle, .navigation').click(function (event) {
        event.stopPropagation();
    });
    jQuery('.navigation').click(function (event) {
        event.stopPropagation();
    });


    /*** About Us Page Form Pop***/

    jQuery("#menu-close, .menu-close, .overlayPg").click(function (e) {
        e.preventDefault();
        jQuery("body").removeClass("disable-scroll");
        jQuery(".sidebar-form").removeClass("activesidebar");
        jQuery(".overlayPg").fadeOut();
        jQuery.fn.fullpage.setAllowScrolling(true);
        if (jQuery('.Form__Status__Message.Form__Success__Message').length > 0) {
            location.href = '';
        }

    });

    jQuery(".btn_white:not(#menu-close)").click(function (e) {
        var id = jQuery(this).attr('href');
        if (jQuery(this).hasClass('btnSidebar')) {
            id = "#sidebar-wrapper";
        }
        e.preventDefault();
        jQuery("body").addClass("disable-scroll");
        jQuery(id).addClass("activesidebar");
        jQuery.fn.fullpage.setAllowScrolling(false);
        jQuery(".overlayPg").fadeIn();
    });

    /*** If Validation Error Then Open Form ***/

    if (jQuery(".aboutusPgFrm > form").hasClass('ValidationFail')) {
        jQuery("body").addClass("disable-scroll");
        jQuery(".aboutusPgFrm > form.ValidationFail").parents('.sidebar-form').addClass("activesidebar");
        jQuery.fn.fullpage.setAllowScrolling(false);
        jQuery(".overlayPg").fadeIn();
    }

    if (jQuery('.Form__Status__Message.Form__Success__Message').length > 0) {
        jQuery("body").addClass("disable-scroll");
        jQuery('.Form__Status__Message.Form__Success__Message').parents('.sidebar-form').addClass("activesidebar");
        jQuery.fn.fullpage.setAllowScrolling(false);
        jQuery(".overlayPg").fadeIn();
    }

    /*** Download Form Pop***/
    jQuery(".downloadPdf").click(function (e) {
        e.preventDefault();
        jQuery("body").addClass("disable-scroll");
        jQuery("#downloadForm").addClass("activesidebar");
        jQuery(".overlayPg").fadeIn();

        var pdflink = jQuery(this).attr('data-pdf');
        var temptitle = jQuery(this).attr('data-pdf-title');
        jQuery("#fileTitle").attr('value', temptitle);
        jQuery("#downloadpdfLink").hide().attr('href', pdflink);


    });


    jQuery('.PdfSubmit').click(function (e) {
        e.stopPropagation();
        jQuery('#pdfname').prop('required', true);

        jQuery('#pdfemail').prop('required', true);


        if (jQuery('#pdfname').val().length > 1) {
            jQuery('#pdfname').addClass('onegot');
        } else {
            jQuery('#pdfname').removeClass('onegot');
        }

        if (validateEmailId('#pdfemail')) {
            jQuery('#pdfemail').addClass('onegot');
        } else {
            jQuery('#pdfemail').removeClass('onegot');
        }
        if (jQuery('#downloadForm .onegot').length == 2) {
            jQuery("#downloadpdfLink").trigger("click");
        }
    });

    jQuery("#downloadpdfLink").click(function () {
        var newurldownload = jQuery(this).attr('href');
        window.open(newurldownload, '_blank');
    });



    jQuery('.subscribe-submit').click(function (e) {
        e.stopPropagation();
        jQuery('#mavenname').prop('required', true);
        jQuery('#mavenemail').prop('required', true);
    });

    jQuery('.footerContact .footercol-2  a > i').text('phone');

    /** mobile slider js **/

    if (jQuery(window).width() < 768) {
        jQuery('.owlSlider').owlCarousel({
            loop: false,
            nav: true,
            margin: 10,
            center: true,
            //navText: ["<span class='ArrowLeft'></span>", "<span class='ArrowRight'></span>"],
            responsive: {
                768: {
                    items: 1
                },
                480: {
                    items: 1
                },
                320: {
                    items: 1
                }
            }
        });
        jQuery('.footerLinks > div h5').click(function () {
            if (jQuery(this).hasClass('active')) {
                jQuery(this).removeClass('active').siblings('ul').slideUp("slow");
            } else {
                jQuery('.footerLinks > div h5').removeClass('active').siblings('ul').slideUp("slow");
                jQuery(this).addClass('active').siblings('ul').slideDown("slow");
            }

        });
    }
		
     /*customer logo*/
    var children = jQuery('.customers-logo .customer');
    if (jQuery(window).width() > 767) {
        for (var i = 0, l = children.length; i < l; i += 2) {
            children.slice(i, i + 2).wrapAll('<div class="parent"></div>');
        }
    }
    jQuery('.customers-logo').owlCarousel({
        loop: false,
        nav: true,
        margin: 0,
        autoplay: false,
        items: 6,
        //navText: ["<span class='ArrowLeft'></span>", "<span class='ArrowRight'></span>"],
        responsive: {
            1440: {
                items: 6
            },
            1280: {
                items: 4
            },
            1024: {
                items: 3
            },
            768: {
                items: 2
            },
            320: {
                items: 1
            }
        }
    });
		jQuery('.awards-slider').owlCarousel({
        loop: true,
        nav: true,
        margin: 0,
        autoplay: true,
        items: 6,
        responsive: {
            1440: {
                items: 6
            },
            1366: {
                items: 5
            },
            1280: {
                items: 4
            },
            768: {
                items: 2
            },
            320: {
                items: 1
            }
        }
    });
	jQuery('.awardsLogo').owlCarousel({
        loop: true,
        nav: false,
        margin: 0,
        autoplay: true,
        items: 8,
        responsive: {
            1440: {
                items: 8
            },
			1366: {
				items: 6
			},
            1280: {
                items: 5
            },
            768: {
                items: 4
            },
            680: {
                items: 3
            },
            420: {
                items: 2
            },
            320: {
                items: 1
            }
        }
    });
	
    if (jQuery('.locationRight li').length > 0) {
        /* Location tab */
       // jQuery('ul.locationRight').tabs();
    }

    /* Award Section*/
    jQuery(".btnBotttom").click(function () {
        jQuery(this).toggleClass("highlight");
        jQuery(".awardsBox").toggleClass("awardOverlay");
        jQuery('html, body').animate({
            scrollTop: jQuery(".awardsBox .awardHide").offset().top
        }, 500, 'easeOutExpo');
    });

    /*-------------------------------------------------------*/
    /* Scroll Button
     /*-------------------------------------------------------*/
    jQuery(document).on('click', '.jumptosec', function (e) {
        e.preventDefault();
        var slideNum = parseInt(jQuery(this).attr('data-slidenum'));
        jQuery.fn.fullpage.moveTo(slideNum);
    });


    /* ----------------------------------------------*/
    /*  Active Class Add In Menu
     /*-----------------------------------------------*/
    //jQuery(".topLinks a").click(function (e) {
    //        var link = jQuery(this);
    //        var item = link.parent("li");
    //        if (item.hasClass("active")) {
    //            item.removeClass("active").children("a").removeClass("active");
    //        } else {
    //            item.addClass("active").children("a").addClass("active");
    //        }
    //        if (item.children("ul").length > 0) {
    //            var href = link.attr("href");
    //            link.attr("href", "#");
    //            setTimeout(function () {
    //                link.attr("href", href);
    //            }, 100);
    //            e.preventDefault();
    //        }
    //    })
    //    .each(function () {
    //        var link = jQuery(this);
    //        if (link.get(0).href === location.href) {
    //            link.addClass("active").parents("li").addClass("active");
    //            return false;
    //        }
    //    });

    /* ----------------------------------------------*/
    /*  For Mobile Change Background Color of Menu
     /*-----------------------------------------------*/
    if (jQuery(window).width() < 768) {
        jQuery(window).scroll(function () {
            var scroll = jQuery(window).scrollTop();
            var bannerScreen = jQuery('.innerPgBanner, .homeBanner').height();
            if (scroll >= bannerScreen) {
                jQuery("body").addClass("navColor");
            } else {
                jQuery("body").removeClass("navColor");
            }
        });
    }

    /* ----------------------------------------------*/
    /*  For Prefect Scrollbar
     /*-----------------------------------------------*/
    if (jQuery(window).width() > 767) {

        jQuery('.scrollBox').perfectScrollbar({suppressScrollX: true, maxScrollbarLength: 100});

    }

    /* ----------------------------------------------*/
    /*  Accordion
     /*-----------------------------------------------*/

    if (jQuery(window).width() < 768) {
        jQuery('.accordionCus > h5').click(function (e) {
            if (jQuery(this).parent().hasClass('activeMinus')) {

                jQuery(this).parent().removeClass('activeMinus');
                jQuery(this).next('.mobItem').removeClass('active-accordion').slideUp('slow');

            } else {

                jQuery(this).parents('.accordionParent').find('.active-accordion').slideUp('slow').removeClass('active-accordion');
                jQuery(this).parents('.accordionParent').find('.activeMinus').removeClass('activeMinus');
                jQuery(this).parent().addClass('activeMinus');
                jQuery(this).next('.mobItem').addClass('active-accordion').slideDown('slow');

            }
        });

    }


    /* ----------------------------------------------*/
    /* reBuild fullpage js
    /*-----------------------------------------------*/

    if (jQuery('#fullPageSection').length > 0 && jQuery(window).width() > 767) {
        jQuery.fn.fullpage.reBuild();
    }

    /* ----------------------------------------------*/
    /* Set Time With Zones fullpage js
    /*-----------------------------------------------*/

    jQuery('.location-content .time').each(function (e) {
        var offset = jQuery(this).attr('utc-offset');
        jQuery(this).jclock({
            format: '<span class=\"dt\">%I:%M %P</span>',
            timeNotation: '12h',
            am_pm: true,
            utc: true,
            utc_offset: offset
        });

    });
    jQuery('.showImage a').click(function (e) {
        e.preventDefault();
        jQuery(this).parent().siblings('.material-placeholder').find('.materialboxed').trigger('click');
    });


    /* ----------------------------------------------*/
    /* Inner page Content slider
    /*-----------------------------------------------*/
    
    if (jQuery(".innercontentScroll").length > 0) {
        jQuery('.owl-carouselinner').owlCarousel({
            autoplay: false,
            autoplayTimeout: 0,
            autoplaySpeed: 700,
            loop: false,
            nav: true,
            items: 1,
            navText: ["", ""],
            onTranslated: updateIndex
        });

        var totalSlide = jQuery(".innercontentScroll .owl-dots .owl-dot").length;
        var currentSlide = jQuery(".innercontentScroll .owl-dots .owl-dot.active").index() + 1;
        jQuery(".innercontentScroll .owl-nav").append("<span></span>");
        jQuery(".innercontentScroll .owl-nav span").text(currentSlide + "/" + totalSlide);


        function updateIndex() {
            currentSlide = jQuery(".innercontentScroll .owl-dots .owl-dot.active").index() + 1;
            jQuery(".innercontentScroll .owl-nav span").text(currentSlide + "/" + totalSlide);
        }
    }
    
    /* ----------------------------------------------*/
    /* Accodion For Web
    /*-----------------------------------------------*/
    
     jQuery('.accordionCus1 > h5').click(function (e) {
            if (jQuery(this).parent().hasClass('activeMinus1')) {

                jQuery(this).parent().removeClass('activeMinus1');
                jQuery(this).next('.viewItemAccordion').removeClass('active-accordion1').slideUp('slow');

            } else {

                jQuery(this).parents('.accordionouter').find('.active-accordion1').slideUp('slow').removeClass('active-accordion1');
                jQuery(this).parents('.accordionouter').find('.activeMinus1').removeClass('activeMinus1');
                jQuery(this).parent().addClass('activeMinus1');
                jQuery(this).next('.viewItemAccordion').addClass('active-accordion1').slideDown('slow');

            }
        });
    
    
    //jQuery('select').material_select();
     jQuery("select.address").msDropdown({ visibleRows: 4, size: 20 });


     jQuery('.address').on('change', function () {
         var tabName = jQuery(this).val();
         if (tabName != '') {
             jQuery('.bgcontactspan, .location-content').fadeOut('slow');
             var background = jQuery('.location-content[data-value="' + tabName + '"]').attr('data-bg');
             jQuery('.location-content[data-value="' + tabName + '"]').fadeIn();
             jQuery('.bgcontactspan[data-background="' + background + '"]').fadeIn();
         }
     });
    
   
    
//jQuery('input.select-dropdown').change(function() {
//    alert('hi')  ;
//});

     /*jQuery('#findajobButton').click(function (e) {
        var ek = jQuery('#ek');
        var el = jQuery('#el');
        if (el.val() == '' || ek.val() == '') {
            if (ek.val() == '') {
                ek.addClass('invalid');
            }
            if (el.val() == '') {
                el.addClass('invalid');
            }
        } else {
            el.removeClass('invalid');
            ek.removeClass('invalid');
            jQuery('#findajob').submit();
        }
    });*/
    
});


jQuery(window).scroll(function () {
    var windowScrollAmount = jQuery(window).scrollTop();
    if (windowScrollAmount > 0) {
        jQuery('body').addClass('fixNav');
    } else {
        jQuery('body').removeClass('fixNav');
    }
});


jQuery(window).load(function () {
    jQuery('.loading-container').fadeOut(function () {
        jQuery(this).remove();
        //owl.trigger('play.owl.autoplay');        
    });
    new WOW({
        mobile: false, // default
    }).init();

    if (jQuery(window).width() > 767) {

        jQuery('.scrollBox').perfectScrollbar('update');

    }

});


jQuery(window).resize(function () {
    if (jQuery('#chart-legend-pointstyle').length > 0) {
        chartW = jQuery('#chart-legend-pointstyle').width();
        chart.reset();
    }
});


// Captcha and Email validation code 
function validateform() {
    jQuery('#name').prop('required', true);
    jQuery('#email').prop('required', true);

    //jQuery('.recaptcha .input-field p.errorMsg').remove();
    //var captcha_response = grecaptcha.getResponse();
    if (jQuery('#name').val().length > 0) {
        if (validateEmailId('#email')) {
            return true;
        } else {
            // jQuery('#email').focus();
            jQuery('#email').addClass('invalid');
            return false;
        }
    } else {
        //jQuery('#name').focus();
        jQuery('#name').addClass('invalid');
        return false;
    }
}

function validateDigitalform() {
    jQuery('#digital_name').prop('required', true);
    jQuery('#digital_email').prop('required', true);

    //jQuery('.recaptcha .input-field p.errorMsg').remove();
    //var captcha_response = grecaptcha.getResponse();
    if (jQuery('#digital_name').val().length > 0) {
        if (validateEmailId('#digital_email')) {
            
            return true;
        } else {
            // jQuery('#digital_email').focus();
            jQuery('#email').addClass('invalid');
            return false;
        }
    } else {
        //jQuery('#digital_name').focus();
        jQuery('#digital_name').addClass('invalid');
        return false;
    }
}

function validateStaffingform() {
    jQuery('#staffing_name').prop('required', true);
    jQuery('#staffing_email').prop('required', true);

   // jQuery('.recaptcha .input-field p.errorMsg').remove();
    //var captcha_response = grecaptcha.getResponse();
    if (jQuery('#staffing_name').val().length > 0) {
        if (validateEmailId('#staffing_email')) {
            return true;
        } else {
            // jQuery('#staffing_email').focus();
            jQuery('#staffing_email').addClass('invalid');
            return false;
        }
    } else {
        //jQuery('#staffing_name').focus();
        jQuery('#staffing_name').addClass('invalid');
        return false;
    }
}

function validateInfoproform() {
    jQuery('#infopro_name').prop('required', true);
    jQuery('#infopro_email').prop('required', true);

    //jQuery('.recaptcha .input-field p.errorMsg').remove();
    //var captcha_response = grecaptcha.getResponse();
    if (jQuery('#infopro_name').val().length > 0) {
        if (validateEmailId('#infopro_email')) {
            return true;
        } else {
            // jQuery('#infopro_email').focus();
            jQuery('#infopro_email').addClass('invalid');
            return false;
        }
    } else {
        //jQuery('#infopro_name').focus();
        jQuery('#infopro_name').addClass('invalid');
        return false;
    }
}

function validateEmailId(e) {
    var x = jQuery(e).val();
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        return false;
    } else {
        return true;
    }
		
		

    
		
		
}