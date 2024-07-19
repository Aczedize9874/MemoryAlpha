        function updateCountdown() {
            if (!countdownPaused) {
                let currentClock = document.getElementById('clock' + currentClockDigit);
                let [hours, minutes, seconds] = currentClock.textContent.split(':').map(Number);

                if (seconds === 0) {
                    if (minutes === 0) {
                        if (hours === 0) {
                            countdownPaused = true;
                            alert("Contagem regressiva finalizada");
                            return;
                        } else {
                            hours--;
                            minutes = 59;
                        }
                    } else {
                        minutes--;
                    }
                    seconds = 59;
                } else {
                    seconds--;
                }

                currentClockDigit = currentClockDigit === 1 ? 2 : 1;
                let nextClock = document.getElementById('clock' + currentClockDigit);
                if (!nextClock) {
                    nextClock = document.createElement('div');
                    nextClock.classList.add('digit');
                    nextClock.id = 'clock' + currentClockDigit;
                    clockContainer.appendChild(nextClock);
                }
                nextClock.textContent = ('00' + hours).slice(-2) + ':' +
                    ('00' + minutes).slice(-2) + ':' +
                    ('00' + seconds).slice(-2);
                nextClock.classList.add('show');
                currentClock.classList.remove('show');

                countdownTimeout = setTimeout(updateCountdown, 1000);
            }
        }
