simplcommerce using Provengo
This directory contains the Provengo project for testing simplcommerce software .

## Running the tests
To run a single random test, run:
```shell 
provengo run simplcommerce
```

See the [Provengo README](simplcommerce/README.md) for more useful commands.

## API
See [Provengo README](simplcommerce/README.md) for a short description of the API.
For a full documentation go to [https://docs.provengo.tech](https://docs.provengo.tech)

## How we tested:
1. We started by creating the [story files](simplcommerce/spec/js/OrderPizza.story.js).
2. We then ran the following command to generate the test model:
```shell
provengo analyze -f PDF simplcommerce   
```
3. We repeated steps 1-2 until we were satisfied with the generated model.
4. We added [Event definitions](simplcommerce/spec/js/OrderPizza.EventDef.js) to define how the stories actuate the website using Selenium.
5. We used the following command to run the tests:
```shell
provengo run --show-sessions simplcommerce
```
6. We repeated steps 4-5 until we were satisfied with the result.
7. We recorded a video of the running tests and added it to the report. Since more than one browser session was opened, we recorded the entire screen. The link for the video is https://drive.google.com/file/d/1z0U8z7u4HYO-fRNEVDVeCl_ZK3eJbLzH/view?usp=share_link].
8. We copied the generated graph of the model to a file named [model.pdf](model.pdf) inside this directory (the link should work).

### Story files
The test stories are in [Tests.story.js](simplcommerce/spec/js/Product.story.js). See the file for a detailed description of the stories.

### Events definition files
The specification for the events are given in [EventDef.js](simplcommerce/spec/js/Product.EventDef.js). See the file for a detailed description of the events.

