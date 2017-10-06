'use strict';

var outDir = '../src/main/webapp/';
var resDir = outDir + 'res/';
var indexDir = outDir;
var resourcesDir = '../src/main/resources/';
var resCss = resDir + 'style/css/';
var resFonts = resDir + 'style/fonts/';
var resImages = resDir + 'style/images/';
var resJs = resDir + 'js/';
var bowerDir = outDir + 'bower_components';
var webinfDir = outDir + 'WEB-INF';
var metainfDir = outDir + 'META-INF';
var pagesDir = outDir + 'html';
var urlPrefix = '$urlprefix';
var urlPrefixDev = 'http://localhost:8080/nl_codewasher/neues_leben_codewasher/';
var urlPrefixProd = 'http://www.codewasher.com/nl_codewasher/neues_leben_codewasher/';
var baseUrl = '$baseUrl';
var baseUrlDev = 'http://localhost:8080/nl_codewasher_client/';
var baseUrlProd = 'http://www.codewasher.com/nl_codewasher_client/';
var filteringDir = 'app/filtering-source';
var appScriptsCommonDir = 'app/scripts/config';

var gulp = require('gulp');
var clean = require('gulp-clean');
var less = require('gulp-less');
var minify = require('gulp-clean-css');
var rename = require('gulp-rename');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var ngAnnotate = require('gulp-ng-annotate');
var mainBowerFiles = require('gulp-main-bower-files');
var wiredep = require('wiredep').stream;
var inject = require('gulp-inject');
var replace = require('gulp-replace');
var sourcemaps = require('gulp-sourcemaps');

gulp.task('default', function () {
    console.log("I have configured a gulp file! I won't do anything!");
});

gulp.task('clean', ['clean-res', 'clean-bower-files', 'clean-web-inf', 'clean-meta-inf', 'clean-index', 'clean-pages'], function () {});

gulp.task('build-folders', ['bower-files', 'styles', 'scripts', 'web-inf-file', 'meta-inf-file', 'pages-dir', 'images'], function () {});

gulp.task('build', ['copy-index-source'], function () {});

gulp.task('clean-res', function () {
    return gulp.src(resDir, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-scripts', function () {
    return gulp.src(resJs, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-styles', function () {
    return gulp.src(resCss, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-images', function () {
    return gulp.src(resImages, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-bower-files', function () {
    return gulp.src(bowerDir, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-web-inf', function () {
    return gulp.src(webinfDir, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-index', function () {
    return gulp.src(outDir + '/index.html', {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-meta-inf', function () {
    return gulp.src(metainfDir, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-pages', function () {
    return gulp.src(pagesDir, {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('clean-index-source', function () {
    return gulp.src(resourcesDir + '/index.html', {
            read: false
        })
        .pipe(clean({
            force: true
        }));
});

gulp.task('styles', ['clean-styles'], function () {
    return gulp.src('app/style/less/nl_codewasher.less')
        //.pipe(sourcemaps.init())
        .pipe(less())
        .pipe(minify())
        //.pipe(sourcemaps.write('cssMaps'))
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(gulp.dest(resCss))
});

gulp.task('scripts', ['clean-scripts'], function () {
    return gulp.src(['app/nl_codewasher.js', 'app/scripts/**/*.js'])
        //.pipe(sourcemaps.init())
        .pipe(concat('nl_codewasher.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        //.pipe(sourcemaps.write('scriptMaps'))
        .pipe(gulp.dest(resJs))
});

gulp.task('images', ['clean-images'], function () {
    return gulp.src(['app/style/images/*.jpg', 'app/style/images/*.png', 'app/style/images/*.gif'])
        .pipe(gulp.dest(resImages))
});

gulp.task('meta-inf-file', ['clean-meta-inf'], function () {
    return gulp.src('META-INF/MANIFEST.MF')
        .pipe(gulp.dest(metainfDir))
});

gulp.task('web-inf-file', ['clean-web-inf'], function () {
    return gulp.src('WEB-INF/**/*.*')
        .pipe(gulp.dest(webinfDir))
});

gulp.task('bower-files', ['clean-bower-files'], function () {
    return gulp.src('./bower.json')
        .pipe(mainBowerFiles())
        .pipe(gulp.dest(bowerDir));
});

gulp.task('pages-dir', ['clean-pages'], function () {
    return gulp.src('app/html/**/*.*')
        .pipe(gulp.dest(pagesDir))
});

gulp.task('copy-index-source', ['clean-index-source', 'build-app'], function () {
    return gulp.src('../src/main/webapp/index.html')
        .pipe(gulp.dest(resourcesDir))
});

gulp.task('build-app', ['clean-index', 'build-folders'], function () {
    var sources = gulp.src([resJs + '**/*.js', resCss + '**/*.css', resImages + '**/*.*'], {
        read: false
    });
    return gulp.src('app/index.html')
        .pipe(wiredep({
            ignorePath: '../'
        }))
        .pipe(inject(sources, {
            ignorePath: outDir,
            addRootSlash: false
        })).pipe(gulp.dest(indexDir));
});

gulp.task('build-dev-filtered-sources', function () {
    gulp.src(filteringDir + '/index.html')
        .pipe(replace(baseUrl, baseUrlDev)).pipe(gulp.dest('app'));
    return gulp.src(filteringDir + '/cw_constants.js')
        .pipe(replace(urlPrefix, urlPrefixDev)).pipe(gulp.dest(appScriptsCommonDir));
});

gulp.task('build-prod-filtered-sources', function () {
    gulp.src(filteringDir + '/index.html')
        .pipe(replace(baseUrl, baseUrlProd)).pipe(gulp.dest('app'));
    return gulp.src(filteringDir + '/cw_constants.js')
        .pipe(replace(urlPrefix, urlPrefixProd)).pipe(gulp.dest(appScriptsCommonDir));
});


gulp.task('watch', function () {
    gulp.watch(['app/html/*.html', 'app/scripts/**/*.js', 'app/style/less/*.less'], function () {
        gulp.run('build');
    });
});
