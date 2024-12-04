# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2024.08.07]

### Added

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07


## [2024.09.16]

### Added

- Designed a StockPortfolio component
- Designed a BankAccount component
- Designed a DNASequence component

## [2024.10.02]

### Added

- Designed a proof of concept for BankAccount component

### Updated

- Changed design to include multiple features such as adding accounts,
removing accounts, adding and removing money, calculating interest, getting
the type of an account, getting values of accounts, adding a overdraft fee,
getting the total number of accounts, and getting the total money in all
accounts.

## [2024.10.17]

### Added

- Designed kernel and enhanced interfaces for BankAccount component

### Updated

- Changed design to include all method contracts for the implementations of all
the method from the proof of concept
- Extended Standard into BankAccountKernel and included 4 methods in the
kernel
- Extended BankAccountKernel into BankAccount and included 6 more methods in
the BankAccount

## [2024.10.30]

### Added

- Designed abstract class for BankAccountSecondary component

### Updated

- Changed design to include Secondary method with the data of a HashMap with
Strings as the keys and Account class as the values as long as data for the
size of the map or the total accounts
- Added Code for totalAccounts, addAccount, removeAccount, and hasAccount
methods and implemented them in the Secondary method
- Added implementation for hashCode and toString for BankAccount

## [2024.11.15]

### Added

- Designed kernel implementation for BankAccountMap component

### Updated

- Changed design to include all of the implementations and data for all of the
methods. This included a constructer for BankAccountMap, all of the methods from
BankAccount and, BankAccountKernel.
- Implemented transferFrom, clear, and newInstance from Standard

## [2024.12.03]

### Added

- Designed test suite for BankAccount component
- Designed two different use cases for BankAccount component

### Updated

- Changed design to include overdraft fees when removing money and account
balance goes negative
- Added equals method
- Added test cases for all kernel and secondary methods
- Added two real world applications for the BankAccount component with main methods
- Organized and polished files to make sure everything was up to standards