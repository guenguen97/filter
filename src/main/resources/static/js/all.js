  new fullpage("#fullpage", {
//options here
autoScrolling: true,
scrollHorizontally: true,
sectionsColor: ["pink", "white", "white", "plum"],
//a태그 링크 url주소로 바꿔야함
anchors: ["section1", "section2", "section3", "section4"],
//navigation 동그라미 버튼 페이지
navigation: true,
navigationPosition: "left",
navigationTooltips: ["section1", "section2", "section3", "section4"],
//navigation 이름을 계속 뜸
showActiveTooltip: true,
slidesNavigation: true,
//마지막페이지 스크롤하면 첫번째 페이지로 이동
loopBottom: true,
//첫번째 페이지 스크롤하면 마지막페이지로 이동
loopTop: true,
});
