package com.example.cleancoder.function;

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.PageCrawlerImpl;
import fitnesse.wiki.PageData;
import fitnesse.wiki.PathParser;
import fitnesse.wiki.WikiPage;
import fitnesse.wiki.WikiPagePath;

public class FitnessExample {
    public String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        return new SetUpTearDownSurrounder(pageData, includeSuiteSetup).surround();
    }

    private class SetUpTearDownSurrounder {
        private final PageData pageData;
        private final boolean includeSuiteSetup;
        private final WikiPage wikiPage;
        private final StringBuffer buffer;

        public SetUpTearDownSurrounder(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            this.wikiPage = pageData.getWikiPage();
            this.buffer = new StringBuffer();
        }

        public String surround() throws Exception {
            if (isTestPage()) {
                surroundPageWithSetUpsAndTearDowns();
            }

            return pageData.getHtml();
        }

        private void surroundPageWithSetUpsAndTearDowns() throws Exception {
            includeSetups();
            buffer.append(pageData.getContent());
            includeTearDowns();
            pageData.setContent(buffer.toString());
        }

        private boolean isTestPage() throws Exception {
            return pageData.hasAttribute("Test");
        }

        private void includeSetups() throws Exception {
            if (includeSuiteSetup) {
                includeInherited(SuiteResponder.SUITE_SETUP_NAME, "setup");
            }
            includeInherited("SetUp", "setup");
        }

        private void includeTearDowns() throws Exception {
            includeInherited("TearDown", "teardown");
            if (includeSuiteSetup) {
                includeInherited(SuiteResponder.SUITE_TEARDOWN_NAME, "teardown");
            }
        }

        private void includeInherited(String suiteSetupName, String mode) throws Exception {
            WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(suiteSetupName, wikiPage);
            if (suiteSetup != null) {
                includePage(suiteSetup, mode);
            }
        }

        private void includePage(WikiPage suiteSetup, String mode) throws Exception {
            WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
            String pagePathName = PathParser.render(pagePath);
            buffer.append("!include -" + mode + " .").append(pagePathName).append("\n");
        }
    }
}
