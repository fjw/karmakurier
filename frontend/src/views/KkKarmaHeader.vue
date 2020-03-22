<template>
  <div>

      <div class="container" ref="container">

            <canvas ref="cv"></canvas>

            <div>
              <hr />
              <hr />
            </div>

            <div class="badge">
              <div class="ribbons">
                <img src="@/assets/illustrations/badge_ribbons.svg" />
              </div>
              <div class="circle">
                <img src="@/assets/illustrations/badge.svg" />
              </div>
              <div class="points">{{points}}</div>
              <div class="plabel">karmapunkte</div>
            </div>
          </div>
  </div>
</template>

<script>
var SCREEN_WIDTH = window.innerWidth;
var SCREEN_HEIGHT = window.innerHeight;

var RADIUS = 300;

var RADIUS_SCALE = 1;
var RADIUS_SCALE_MIN = 1;
var RADIUS_SCALE_MAX = 1.5;

var mouseIsDown = false;

export default {
  name: "KkKarmaHeader",
  data() {
    return {
      points: 36,
      ctx: null,
      particles: []
    };
  },
  methods: {
    randomNumber(index) {
      let randomNumbers = [];
      for (let i = 0; i < 34; i += 1) {
        randomNumbers.push(Math.round(Math.random() * 100));
      }
      return randomNumbers[index];
    },

    createParticles() {
      this.particles = [];

      for (var i = 0; i < this.points; i++) {
        var particle = {
          size: 1,
          position: {
            x: (Math.random() >= 0.5 ? 0 : 1) * this.ctx.canvas.width,
            y: Math.random() * 340
          },
          offset: { x: 0, y: 0 },
          shift: {
            x: (Math.random() >= 0.5 ? 0 : 1) * this.ctx.canvas.width,
            y: Math.random() * 340
          },
          speed: 0.002 + Math.random() * 0.008,
          targetSize: 1,
          fillColor: "hsl(17, 100%, 72%)",
          orbit: RADIUS * 0.5 + RADIUS * 0.5 * Math.random()
        };

        this.particles.push(particle);
      }
    },

    loop() {
      if (mouseIsDown) {
        RADIUS_SCALE += (RADIUS_SCALE_MAX - RADIUS_SCALE) * 0.02;
      } else {
        RADIUS_SCALE -= (RADIUS_SCALE - RADIUS_SCALE_MIN) * 0.02;
      }

      RADIUS_SCALE = Math.min(RADIUS_SCALE, RADIUS_SCALE_MAX);

      this.ctx.fillStyle = "rgba(255,255,255,0.7)";
      this.ctx.fillRect(0, 0, this.ctx.canvas.width, this.ctx.canvas.height);

      var mouseX = this.ctx.canvas.width / 2; //dirty
      var mouseY = 150;

      for (var i = 0, len = this.particles.length; i < len; i++) {
        var particle = this.particles[i];

        var lp = { x: particle.position.x, y: particle.position.y };

        // Rotation
        particle.offset.x += particle.speed;
        particle.offset.y += particle.speed;

        // Follow mouse with some lag
        particle.shift.x += (mouseX - particle.shift.x) * particle.speed;
        particle.shift.y += (mouseY - particle.shift.y) * particle.speed;

        // Apply position
        particle.position.x =
          particle.shift.x +
          Math.cos(i + particle.offset.x) * (particle.orbit * RADIUS_SCALE);
        particle.position.y =
          particle.shift.y +
          Math.sin(i + particle.offset.y) * (particle.orbit * RADIUS_SCALE);

        // Limit to screen bounds
        particle.position.x = Math.max(
          Math.min(particle.position.x, SCREEN_WIDTH),
          0
        );
        particle.position.y = Math.max(
          Math.min(particle.position.y, SCREEN_HEIGHT),
          0
        );

        particle.size += (particle.targetSize - particle.size) * 0.05;

        if (Math.round(particle.size) == Math.round(particle.targetSize)) {
          particle.targetSize = 1 + Math.random() * 7;
        }

        this.ctx.beginPath();
        this.ctx.fillStyle = particle.fillColor;
        this.ctx.strokeStyle = particle.fillColor;
        this.ctx.lineWidth = particle.size;
        this.ctx.moveTo(lp.x, lp.y);
        this.ctx.lineTo(particle.position.x, particle.position.y);
        this.ctx.stroke();
        this.ctx.arc(
          particle.position.x,
          particle.position.y,
          particle.size / 2,
          0,
          Math.PI * 2,
          true
        );
        this.ctx.fill();
      }
    }
  },
  mounted() {
    window.addEventListener(
      "resize",
      () => {
        this.$refs.cv.width = this.$refs.container.offsetWidth;
        this.$refs.cv.height = 340;
      },
      false
    );

    this.$refs.cv.width = this.$refs.container.offsetWidth;
    this.$refs.cv.height = 340;

    this.ctx = this.$refs.cv.getContext("2d");

    //this is dirty, solle windowanimationframe sein
    this.createParticles();
    setInterval(this.loop, 1000 / 60);
  }
};
</script>

<style scoped lang="scss">
@import "@/components/Branding.scss";



.badge {
  width: 300px;
  height: 340px;
  position: relative;
  margin: auto;

  > div {
    width: 300px;
  }

  .circle {
    position: absolute;
    top: 0;
    left: 0;

    animation-name: ckw;
    animation-duration: 60s;
  }

  .ribbons {
    position: absolute;
    top: 25px;
    left: 0;
  }

  .points {
    position: absolute;
    top: 104px;
    left: 0;

    font-family: "Quicksand", sans-serif;
    font-weight: bold;
    text-align: center;
    font-size: 50px;
  }

  .plabel {
    position: absolute;
    top: 162px;
    left: 0;

    text-align: center;
    color: $secondary;
  }
}

@keyframes ckw {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

hr {
  border-bottom: 3px solid $primary;

  position: absolute;

  top: 150px;
  left: 20px;

  width: 35%;

  &:last-child {
    right: 20px;
    left: initial;
  }
}

.container {
    position: relative;
}


canvas {
  position: absolute;
}
</style>